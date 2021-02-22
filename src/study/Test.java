package study;

import study.admin.Admin;
import study.cinemas.CinemaRB;
import study.cinemas.Film;
import study.cinemas.Genre;
import study.cinemas.Ticket;
import study.cinemas.exceptionhandling.NoSuchFilmException;
import study.cinemas.exceptionhandling.NoSuchSeatException;
import study.client.Client;
import study.staff.Cassir;
import study.staff.Director;
import study.staff.Staff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test {

    public static final Path targetPath = Paths.get("C:\\Users\\HP\\Desktop\\");

    public static List<Integer> seats(Integer maxCapacitySeats) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxCapacitySeats; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Film> films() {
        List<LocalDateTime> times = new ArrayList<LocalDateTime>() {{
            add(LocalDateTime.now());
            add(LocalDateTime.now().plusHours(3));
            add(LocalDateTime.now().plusHours(6));
        }};
        List<Film> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Film("Film-" + i, Genre.values()[i], times));
        }
        return list;
    }

    public static void main(String[] args) throws NoSuchSeatException, NoSuchFilmException {

        CinemaRB cinemaMir = new CinemaRB("MIR", new Admin("Vlad", "Prokov"), new Staff(new Director("Vasya", "Sidorov"), new Cassir("Elena", "Ivanova")), seats(30), films());

        CinemaRB cinemaPobeda = new CinemaRB("Pobeda", cinemaMir.getAdmin(), new Staff(new Director("Petya", "Petrov"), new Cassir("Ira", "Smirnova")), seats(25), films());


        System.out.println(cinemaMir.toString());
        System.out.println(cinemaPobeda.toString());

        System.out.println("------------------");
        Admin admin = cinemaMir.getAdmin();
        admin.setNewDirector(cinemaPobeda, new Director("Serega", "Kent"));
        admin.deleteDirector(cinemaMir);
        admin.setNewCassir(cinemaPobeda, new Cassir("Luda", "Svanidze"));

        System.out.println(cinemaMir.toString());
        System.out.println(cinemaPobeda.toString());

        System.out.println("-----------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our CINEMA!!! Enter your name: ");

        String name = input.nextLine();
        Client client = new Client(name);
        System.out.println(String.format("Dear %s choose a film you want to watch: ", client.getName()));
        AtomicInteger i = new AtomicInteger();
        cinemaMir.getFilms().forEach(e -> System.out.println(i.getAndIncrement() + ", " + e.getFilmName() + ", " + e.getGenre()));
        Film filmNumber = filmNumber(input, cinemaMir.getFilms());

        System.out.println("Choose a seat for watching: \n");
        List<Integer> seatNumbers = cinemaMir.getSeatNumbers();
        cinemaMir.getSeatNumbers().forEach(e -> System.out.print(e + ", "));
        Integer seatNumber = seatNumber(input, seatNumbers);

        System.out.println("Choose a convenient time for watching: ");
        Film film = cinemaMir.getFilms().stream().filter(e -> e.equals(filmNumber)).findFirst().get();
        AtomicInteger i1 = new AtomicInteger(1);
        film.getTimes().forEach(e -> System.out.println(i1.getAndIncrement() + ", " + e.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))));


        LocalDateTime time = filmTime(input, film.getTimes());

        Cassir cassirFromCinemaMir = cinemaMir.getStaff().getCassir();
        Ticket newTicket = cassirFromCinemaMir.createNewTicket(cinemaMir, 7.0, filmNumber, seatNumber, time);
        System.out.println("Кассир выдает билет......");
        cassirFromCinemaMir.addTicketInCinema(cinemaMir, newTicket);

        try {
            Path directory = Paths.get(targetPath.resolve(cinemaMir.getName()).toString());
            if (!new File(directory.toUri()).exists()) {
                Files.createDirectory(targetPath.resolve(cinemaMir.getName()));
            }
            if (!new File(directory.resolve(client.getName() + ".txt").toUri()).exists()) {
                Path file = Files.createFile(directory.resolve(client.getName() + ".txt"));
                Files.write(file, newTicket.toString().getBytes(), StandardOpenOption.CREATE);
            } else {
                // заглушка для дубликатов
                Random random = new Random();
                Path file = Files.createFile(directory.resolve(client.getName()+"_"+ random.nextInt(1000) + ".txt"));
                Files.write(file, newTicket.toString().getBytes(), StandardOpenOption.CREATE);
            }
            System.out.println("Ваш билет готов!\nСмотрите ваш билет в папке на компе по пути: " + directory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Film filmNumber(Scanner scanner, List<Film> films) {
        int filmNumber = 0;
        try {
            filmNumber = scanner.nextInt();
            if (filmNumber > 6 || filmNumber < 0) {
                System.out.println("Фильма с таким номером нет, выберите другой: ");
                return filmNumber(scanner, films);
            }
            int finalFilmNumber = filmNumber;
            return films.stream().filter(e -> e.getFilmName().contains(String.valueOf(finalFilmNumber))).findFirst().get();
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Вы ввели не число");
            return filmNumber(scanner, films);
        }
    }


    public static Integer seatNumber(Scanner scanner, List<Integer> seats) {
        int seatNumber = 0;
        try {
            seatNumber = scanner.nextInt();
            if (!seats.contains(seatNumber)) {
                System.out.println("Свободного места с таким номером нет, выберите другой: ");
                return seatNumber(scanner, seats);
            }
            return seatNumber;
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Вы ввели не число");
            return seatNumber(scanner, seats);
        }
    }

    public static LocalDateTime filmTime(Scanner scanner, List<LocalDateTime> times) {
        int filmTime = 0;
        try {
            filmTime = scanner.nextInt();
            if (filmTime > times.size() || filmTime <= 0) {
                System.out.println("Фильма с таким временем сеанса нет, выберите другое: ");
                return filmTime(scanner, times);
            }
            if (filmTime == 3) return times.get(filmTime - 1);
            return times.get(filmTime);
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Вы ввели не число");
            return filmTime(scanner, times);
        }
    }
}

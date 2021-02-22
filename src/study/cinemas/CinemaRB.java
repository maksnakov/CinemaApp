package study.cinemas;

import study.admin.Admin;
import study.cinemas.exceptionhandling.NoSuchFilmException;
import study.cinemas.exceptionhandling.NoSuchSeatException;
import study.staff.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinemaRB extends Cinema {

    private Staff staff;
    private List<Integer> seatNumbers;
    private List<Ticket> tickets = new ArrayList<>();
    private List<Film> films;

    public CinemaRB(String name, Admin admin, Staff staff, List<Integer> seatNumbers, List<Film> films) {
        super.setName(name);
        super.setAdmin(admin);
        this.staff = staff;
        this.seatNumbers = seatNumbers;
        this.films=films;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    @Override
    public Staff getStaff() {
        return staff;
    }

    @Override
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String toString() {
        return "Name: " + getName() +
                ", Admin: " + getAdmin().toString() +
                ", Director: " + staff.getDirector().toString() +
                ", Cassir: " + staff.getCassir().toString() +
                ", Seats: " + seatNumbers;

    }

    public Film getOptionalFilm(String filmName) throws NoSuchFilmException {
        Optional<Film> film = getFilms().stream()
                .filter(e -> e.getFilmName().equals(filmName))
                .findFirst();
        if (film.isPresent()) return film.get();
        else throw new NoSuchFilmException(String.format("No such film in Cinema: %s", this.getName()));
    }

    public Integer getAvailableSeat(Integer seatNumber) throws NoSuchSeatException {
        Optional<Integer> first = getSeatNumbers().stream().filter(e -> e.equals(seatNumber)).findFirst();
        if (first.isPresent()) return first.get();
        else throw new NoSuchSeatException(String.format("No such available seat in Cinema: %s", this.getName()));
    }

    public void addNewTicket(Ticket ticket) throws NoSuchFilmException, NoSuchSeatException {
        getOptionalFilm(ticket.getFilm().getFilmName());
        getAvailableSeat(ticket.getSeatNumber());
        this.tickets.add(ticket);

    }

    public void addNewFilm(Film film) {
        this.films.add(film);
    }

}
package study.staff;

import study.cinemas.CinemaRB;
import study.cinemas.Film;
import study.cinemas.Ticket;
import study.cinemas.exceptionhandling.NoSuchFilmException;
import study.cinemas.exceptionhandling.NoSuchSeatException;

import java.time.LocalDateTime;

public class Cassir implements ICassir{

    private String name;
    private String surname;

    public Cassir() {
    }

    public Cassir(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Cassir{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public void addTicketInCinema(CinemaRB cinemaRB, Ticket ticket) throws NoSuchSeatException, NoSuchFilmException {
        cinemaRB.addNewTicket(ticket);
    }

    @Override
    public Ticket createNewTicket(CinemaRB cinemaRB, Double cost, Film film, Integer seatNumber, LocalDateTime dateTime) {
        return new Ticket(cinemaRB, cost, film, seatNumber, dateTime);
    }
}

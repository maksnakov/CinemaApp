package study.staff;

import study.cinemas.CinemaRB;
import study.cinemas.Film;
import study.cinemas.Ticket;
import study.cinemas.exceptionhandling.NoSuchFilmException;
import study.cinemas.exceptionhandling.NoSuchSeatException;

import java.time.LocalDateTime;

public interface ICassir {

    void addTicketInCinema (CinemaRB cinemaRB, Ticket ticket) throws NoSuchSeatException, NoSuchFilmException;
    Ticket createNewTicket (CinemaRB cinemaRB, Double cost, Film film, Integer seatNumber, LocalDateTime dateTime);
}

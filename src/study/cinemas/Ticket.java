package study.cinemas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {

    private String cinemaName;
    private Double cost;
    private Film film;
    private Integer seatNumber;
    private LocalDateTime dateTime;

    public Ticket(CinemaRB cinemaRB, Double cost, Film film, Integer seatNumber, LocalDateTime dateTime) {
        this.cinemaName = cinemaRB.getName();
        this.cost = cost;
        this.film = film;
        this.seatNumber = seatNumber;
        this.dateTime = dateTime;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "cinemaName='" + cinemaName + '\'' +
                ", cost=" + cost +
                ", film=" + film +
                ", seatNumber=" + seatNumber +
                ", dateTime=" + dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) +
                '}';
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
}

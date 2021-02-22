package study.staff;

import study.cinemas.CinemaRB;
import study.cinemas.Film;

public class Director implements IDirector{

    private String name;
    private String surname;

    public Director() {
    }

    public Director(String name, String surname) {
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
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    @Override
    public void addNewFilm(CinemaRB cinemaRB, Film film) {
        cinemaRB.addNewFilm(film);
    }
}

package study.cinemas;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Film {

    private String filmName;
    private Genre genre;
    private List<LocalDateTime> times;

    public Film(String filmName, Genre genre, List<LocalDateTime> times) {
        this.filmName = filmName;
        this.genre = genre;
        this.times = times;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", genre=" + genre +
                '}';
    }

    public Genre getGenre() {
        return genre;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public List<LocalDateTime> getTimes() {
        return times;
    }

    public void setTimes(List<LocalDateTime> times) {
        this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmName, film.filmName) &&
                genre == film.genre &&
                Objects.equals(times, film.times);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, genre, times);
    }
}

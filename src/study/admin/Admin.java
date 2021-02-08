package study.admin;

import study.cinemas.Cinema;
import study.staff.Cassir;
import study.staff.Director;

public class Admin implements IAdmin{
    private String name;
    private String surname;

    public Admin(String name, String surname) {
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
        return "Admin{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public void setNewDirector(Cinema cinema, Director director) {
        cinema.getStaff().setDirector(director);
    }

    @Override
    public void setNewCassir(Cinema cinema, Cassir cassir) {
        cinema.getStaff().setCassir(cassir);
    }

    @Override
    public void deleteDirector(Cinema cinema) {
        cinema.getStaff().setDirector(new Director());
    }

    @Override
    public void deleteCassir(Cinema cinema) {
        cinema.getStaff().setCassir(new Cassir());
    }
}

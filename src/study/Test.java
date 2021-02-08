package study;

import study.admin.Admin;
import study.cinemas.CinemaRB;
import study.staff.Cassir;
import study.staff.Director;
import study.staff.Staff;

public class Test {
    public static void main(String[] args) {

        CinemaRB cinemaMir = new CinemaRB("MIR",
                new Admin("Vlad", "Pro"),
                new Staff(new Director("Vasya", "Sidorov"),
                new Cassir("Elena", "Ivanova")));

        CinemaRB cinemaPobeda = new CinemaRB("Pobeda",
                cinemaMir.getAdmin(),
                new Staff(new Director("Petya", "Petrov"),
                new Cassir("Ira", "Smirnova")));

        System.out.println(cinemaMir.toString());
        System.out.println(cinemaPobeda.toString());

        System.out.println("------------------");
        Admin admin = cinemaMir.getAdmin();
        admin.setNewDirector(cinemaPobeda, new Director("Serega", "Kent"));
        admin.deleteDirector(cinemaMir);
        admin.setNewCassir(cinemaPobeda, new Cassir("Luda", "Svanidze"));

        System.out.println(cinemaMir.toString());
        System.out.println(cinemaPobeda.toString());

    }
}

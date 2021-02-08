package study.admin;

import study.cinemas.Cinema;
import study.staff.Cassir;
import study.staff.Director;

public interface IAdmin {

    void setNewDirector(Cinema cinema, Director director);
    void setNewCassir(Cinema cinema, Cassir cassir);
    void deleteDirector(Cinema cinema);
    void deleteCassir(Cinema cinema);

}

package study.cinemas;

import study.admin.Admin;
import study.staff.Staff;

public class CinemaRB extends Cinema {

    private Staff staff;

    public CinemaRB(String name, Admin admin, Staff staff) {
        setName(name);
        setAdmin(admin);
        this.staff=staff;
    }

    @Override
    public Staff getStaff() {
        return staff;
    }

    @Override
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String toString(){
        return "Name: " + getName() +
                ", Admin: " + getAdmin().toString() +
                ", Director: " + staff.getDirector().toString() +
                ", Cassir: " + staff.getCassir().toString();
    }
}

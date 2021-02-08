package study;

import study.admin.Admin;
import study.client.Client;
import study.staff.Staff;

import java.util.List;

public abstract class Cinema {
    private String name;
    private Admin admin;
    private List<Client> clients;
    private Staff staff;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

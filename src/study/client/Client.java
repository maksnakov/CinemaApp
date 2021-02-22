package study.client;

import study.cinemas.Ticket;

public class Client {

    private String name;
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ticket=" + ticket +
                '}';
    }
}

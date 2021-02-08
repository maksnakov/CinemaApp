package study.staff;

public class Staff {

    private Director director;
    private Cassir cassir;

    public Staff(Director director, Cassir cassir) {
        this.director = director;
        this.cassir = cassir;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Cassir getCassir() {
        return cassir;
    }

    public void setCassir(Cassir cassir) {
        this.cassir = cassir;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "director=" + director +
                ", cassir=" + cassir +
                '}';
    }
}

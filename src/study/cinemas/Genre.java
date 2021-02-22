package study.cinemas;

public enum Genre {

    WESTERN(0),
    COMEDY (1),
    HORROR (2),
    DRAMA (3),
    MELODRAMA (4),
    CARTOON (5),
    BLOCKBUSTER (6);

    private final int id;

    Genre(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

}

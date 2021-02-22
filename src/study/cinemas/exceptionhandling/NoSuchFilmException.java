package study.cinemas.exceptionhandling;

public class NoSuchFilmException extends Throwable {

    public NoSuchFilmException(String message) {
        super(message);
    }
}

package study.cinemas.exceptionhandling;

public class NoSuchSeatException extends Throwable {
    public NoSuchSeatException(String message) {
        super(message);
    }
}

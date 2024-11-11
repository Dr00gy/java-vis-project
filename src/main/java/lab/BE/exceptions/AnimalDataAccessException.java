package lab.BE.exceptions;

public class AnimalDataAccessException extends Exception {

    public AnimalDataAccessException(String message) {
        super(message);
    }

    public AnimalDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

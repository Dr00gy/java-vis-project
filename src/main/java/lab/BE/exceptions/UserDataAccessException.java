package lab.BE.exceptions;

public class UserDataAccessException extends Exception {

    public UserDataAccessException(String message) {
        super(message);
    }

    public UserDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

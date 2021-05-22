package registrationAndLogin.exception;

public class InvalidEmailAddressException extends Exception{
    public InvalidEmailAddressException() {
        super("Invalid email address");
    }

    public InvalidEmailAddressException(String message) {
        super(message);
    }
}


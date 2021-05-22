package registrationAndLogin.exception;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {
        super("Invalid Password: should be of length 8, contain at least 2 uppercase letters and 3 numbers");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}

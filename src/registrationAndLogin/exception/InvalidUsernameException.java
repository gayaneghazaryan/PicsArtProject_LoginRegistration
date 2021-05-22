package registrationAndLogin.exception;

public class InvalidUsernameException extends Exception{
    public InvalidUsernameException() {
        super("Invalid Username: should be of length 10");
    }

    public InvalidUsernameException(String message) {
        super(message);
    }
}

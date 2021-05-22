package registrationAndLogin.exception;

public class InvalidFullNameException extends Exception{
    public InvalidFullNameException() {
        super("Invalid full name: should have \"name surname\" format");
    }
    public InvalidFullNameException(String message) {
        super(message);
    }
}

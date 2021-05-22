package registrationAndLogin.exception;

public class NotExistingUserException extends Exception{
    public NotExistingUserException() {
        super("User with this username does not exist.");
    }
}

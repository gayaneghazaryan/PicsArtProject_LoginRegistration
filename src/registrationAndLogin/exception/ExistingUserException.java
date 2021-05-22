package registrationAndLogin.exception;

public class ExistingUserException extends Exception{
    public ExistingUserException() {
        super("LoginAndRegistration.registrationAndLogin.User with this username already exists.");
    }

    public ExistingUserException(String message) {
        super(message);
    }
}

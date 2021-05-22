package registrationAndLogin;

import registrationAndLogin.exception.*;
import registrationAndLogin.service.*;

public class User {
    private String fullName;
    private String username;
    private String emailAddress;
    private String password;

    public User(String[] info) throws InvalidFullNameException, InvalidUsernameException, InvalidEmailAddressException, InvalidPasswordException {
        setFullName(info[0]);
        setUsername(info[1]);
        setEmailAddress(info[2]);
        setPassword(info[3]);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullNameException {
        if(!ValidationService.isValidFullName(fullName)){
            throw new InvalidFullNameException();
        }
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidUsernameException {
        if(!ValidationService.isValidUserName(username)) {
            throw new InvalidUsernameException();
        }
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws InvalidEmailAddressException {
        if(!ValidationService.isValidEmail(emailAddress)) {
            throw new InvalidEmailAddressException();
        }
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        if(!ValidationService.isValidPassword(password)) {
            throw new InvalidPasswordException();
        }
        this.password = FileService.MD5(password);

    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",fullName,username,emailAddress,password);
    }
}

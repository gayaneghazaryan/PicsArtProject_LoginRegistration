package registrationAndLogin.service;

public class ValidationService {

    public static boolean isValidFullName(String fullName) {
        return fullName.matches("\\w+ \\w+");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

    public static boolean isValidPassword(String password) {
        boolean isValidLength = password.length() > 8;
        boolean isValidUpperCase = password.matches(".*[A-Z].*[A-Z].*");
        boolean isValidNumberOfDigits = password.matches("^(\\D*\\d){3,}\\D*$");

        return  isValidLength && isValidUpperCase && isValidNumberOfDigits;
    }

    public static boolean isValidUserName(String userName) {
        return userName.length() > 10;
    }


}

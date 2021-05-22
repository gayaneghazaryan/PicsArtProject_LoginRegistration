package registrationAndLogin.service;

import registrationAndLogin.User;
import registrationAndLogin.exception.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationAndLoginService {
    public static void createUser(String[] info) throws ExistingUserException, InvalidFullNameException, InvalidPasswordException, InvalidEmailAddressException, InvalidUsernameException {
        if(isExistingUser(info[1])) {
            throw new ExistingUserException();
        }
        addUserToFile(new User(info));
    }

    private static void addUserToFile(User user) {
        try {
            FileService.writeWithAppend("info\\database.txt",user.toString());
            FileService.writeWithAppend("info\\database.txt",System.getProperty( "line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String,String> userMap() {
        List<String> userList = new ArrayList<>();
        try {
            userList = FileService.read("info\\database.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> userMap = new HashMap<>();
        if(!userList.isEmpty()) {
            for(String user: userList) {
                String[] userInfo = user.split(",");
                userMap.put(userInfo[1],userInfo[3]);
            }
        }
        return userMap;
    }

    private static boolean isExistingUser(String username) {
        return userMap().containsKey(username);
    }

    public static boolean isValidLogin(String username,String password) throws NotExistingUserException, InvalidLoginException {
        if(!isExistingUser(username)) {
            throw new NotExistingUserException();
        }else if(!(userMap().get(username).equals((FileService.MD5(password))))){
            throw new InvalidLoginException();
        }
        return true;
    }

}

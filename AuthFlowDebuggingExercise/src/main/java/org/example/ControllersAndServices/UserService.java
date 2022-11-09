package org.example.ControllersAndServices;

import com.sun.javafx.tools.packager.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static Logger logger = LogManager.getLogger(Main.class.getName());

    Map<String, User> map;

    AuthService authService;

    public UserService() {
        this.map = new HashMap<>();
        this.authService = AuthService.getInstance();
    }

    private User isUser(String userEmail){
        Map<String, User> usersData = UserRepo.getUsersData();
        User userExists = usersData.get(userEmail);
        if (userExists == null) {
            logger.error("User doesn't exists");
            throw new IllegalArgumentException("User doesn't exists");
        }
        else
            return userExists;
    }
    void deleteUser(String userEmail){
        User userExists = isUser(userEmail);
        UserRepo.deleteUser(userExists);
        authService.getTokens().remove(userEmail);
    }

    User updateUserEmail(String userEmail , String newEmail){
        User userExists = isUser(userEmail);
        userExists.setEmail(newEmail);
        UserRepo.updateUserEmail(userEmail,userExists);
        String token = authService.getTokens().get(userEmail);
        authService.getTokens().remove(userEmail);
        authService.getTokens().put(token,newEmail);
        return userExists;
    }
    User updateUserName(String userEmail , String userName){
        User userExists = isUser(userEmail);
        userExists.setName(userName);
        UserRepo.updateUser(userExists);
        return userExists;
    }
    User updateUserPassword(String userEmail , String userPassword){
        User userExists = isUser(userEmail);
        userExists.setPassword(userPassword);
        UserRepo.updateUser(userExists);
        return userExists;
    }
}

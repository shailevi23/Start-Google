package org.example.ControllersAndServices;


import com.sun.javafx.tools.packager.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Utils.Utility;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private static Logger logger = LogManager.getLogger(Main.class.getName());
    private Map<String,String> tokens;
    private static AuthService singaleInistance = null;


    AuthService() {
        this.tokens = new HashMap<>();
        UserRepo.initUserRepo();
    }

    String validateUserLogin(String userEmail, String userPassword) {
        logger.info("validate user login in DB: " + "userEmail: " +  userEmail + "userPassword: " + userPassword);
        logger.debug(userEmail, userPassword);
        Map<String, User> usersData = UserRepo.getUsersData();
        if(usersData.get(userEmail) != null)
            if(usersData.get(userEmail).getPassword().equals(userPassword)){
                String token = Utility.RandomString(5);
                tokens.put(token,userEmail);
                logger.info("The user has logged in successfully and got the following token: " + token);
                logger.debug(token, userEmail);
                return token;
            }
        logger.error("Email or password is illegal!!, user cant login");
        throw new IllegalArgumentException("Email or password is illegal!!, user cant login");
    }
    String validateUserRegister(User user) {
        logger.info("validate user registration in DB: " + user.toString());
        logger.debug(user);
        Map<String,User> usersData = UserRepo.getUsersData();
        if(!usersData.isEmpty()) {
            if (usersData.get(user.getEmail()) == null) {
                    UserRepo.saveNewUser(user);
                    logger.info("User has been registered successfully: " + user.toString());
                return validateUserLogin(user.getEmail(), user.getPassword());
            }
            else{
                logger.error("Email has been used!, can't register");
                throw new IllegalArgumentException("Email has been used!");
            }
        }
        else{
            UserRepo.saveNewUser(user);
            logger.info("User has been registered successfully: " + user.toString());
            return validateUserLogin(user.getEmail(), user.getPassword());
        }
    }
    static AuthService getInstance(){
        if(singaleInistance==null)
            singaleInistance = new AuthService();
        return singaleInistance;
    }

    public Map<String, String> getTokens() {
        return tokens;
    }
}

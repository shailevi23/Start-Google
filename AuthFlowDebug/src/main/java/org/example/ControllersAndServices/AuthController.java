package org.example.ControllersAndServices;

import com.sun.javafx.tools.packager.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Utils.Utils;

import java.util.regex.Pattern;

public class AuthController {
    private static Logger logger = LogManager.getLogger(Main.class.getName());

    AuthService authService;

    public AuthController() {
        this.authService = AuthService.getInstance();
    }

    public String createNewUser(String userName,String userEmail,String userPassword) {
        logger.info("userEmail: " + userEmail + "userName: " + userName + " userPassword: " + userPassword);
        logger.debug(userEmail, userName, userPassword);
        return this.validateUserInput(new User(userEmail,userName,userPassword));
    }
    public String userLogin(String userEmail,String userPassword){
        logger.info("userEmail: " + userEmail + "userPassword: " +userPassword);
        logger.debug(userEmail,userPassword);
        return authService.validateUserLogin(userEmail,userPassword);
    }
    private String validateUserInput(User user){
        logger.info("validate user input:" +user.toString());
        logger.debug(user);
        if(isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), Utils.regexEmail, Utils.invalidMail)
                && checkUserInput(user.getName(), Utils.regexUsername, Utils.invalidUsername)
                && checkUserInput(user.getPassword(), Utils.regexPassword, Utils.invalidPassword)){
            return authService.validateUserRegister(user);
        }

        return null;
    }

    private boolean isValidUserId(int id){
        logger.info("check valid id: " + id);
        logger.debug(id);
        if (id < 0) {
            logger.error(Utils.invalidId);
            throw new IllegalArgumentException(Utils.invalidId);
        }
        return true;
    }

    private boolean checkUserInput(String userInput ,String regex ,String message){
        logger.info("checking regex: " + userInput);
        logger.debug(userInput);
        if (!Pattern.compile(regex).matcher(userInput).matches()){
            logger.error(message);
            throw new IllegalArgumentException(message);
        }
        return true;
    }

}

package org.example.App.ControllersAndServices;

import org.example.App.Utils.Utils;

import java.util.regex.Pattern;

public class AuthController {
    AuthService authService;

    public AuthController() {
        this.authService = AuthService.getInstance();
    }

//    public String validateUserInput(User user) {
    public String createNewUser(String userName,String userEmail,String userPassword) {
        return this.validateUserInput(new User(userEmail,userName,userPassword));
    }
    public String userLogin(String userEmail,String userPassword){
        return authService.validateUserLogin(userEmail,userPassword);
    }
    private String validateUserInput(User user){
        if(isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), Utils.regexEmail, Utils.invalidMail)
                && checkUserInput(user.getName(), Utils.regexUsername, Utils.invalidUsername)
                && checkUserInput(user.getPassword(), Utils.regexPassword, Utils.invalidPassword)){
            return authService.validateUserRegister(user);
        }

        return null;
    }

    private boolean isValidUserId(int id){
        if (id < 0) {
            throw new IllegalArgumentException(Utils.invalidId);
        }
        return true;
    }

    private boolean checkUserInput(String userInput ,String regex ,String message){
        if (!Pattern.compile(regex).matcher(userInput).matches()){
            throw new IllegalArgumentException(message);
        }
        return true;
    }

}

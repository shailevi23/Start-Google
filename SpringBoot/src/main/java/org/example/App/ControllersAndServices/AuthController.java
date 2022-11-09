package org.example.App.ControllersAndServices;

import org.example.App.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    public AuthController() {
        this.authService = AuthService.getInstance();
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<User> createNewUser(@RequestBody User user) {
//        if(this.validateUserInput(user)){
//            ResponseEntity.ok(authService.validateUserRegister(user));
//        }
//        return ResponseEntity.ok(authService.validateUserRegister(user));
//        ;
//    }
    public String userLogin(String userEmail,String userPassword){
        return authService.validateUserLogin(userEmail,userPassword);
    }
    private boolean validateUserInput(User user){
        if(isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), Utils.regexEmail, Utils.invalidMail)
                && checkUserInput(user.getName(), Utils.regexUsername, Utils.invalidUsername)
                && checkUserInput(user.getPassword(), Utils.regexPassword, Utils.invalidPassword)){
            return true;
        }

        return false;
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

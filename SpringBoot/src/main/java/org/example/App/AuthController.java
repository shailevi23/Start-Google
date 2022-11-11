package org.example.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
//@RequestMapping("/")
public class AuthController {
    @Autowired
    AuthService authService;

    public AuthController() {
        this.authService = AuthService.getInstance();
    }


    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        if(this.validateUserInput(user)){
            ResponseEntity.ok(authService.validateUserRegister(user));
        }
        return null;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> userLogin(@RequestParam("email") String userEmail, @RequestParam("password") String userPassword){
        return ResponseEntity.ok(authService.validateUserLogin(userEmail,userPassword));
    }
    private boolean validateUserInput(User user){
        return isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), Utils.regexEmail, Utils.invalidMail)
//                && checkUserInput(user.getName(), Utils.regexUsername, Utils.invalidUsername)
                && checkUserInput(user.getPassword(), Utils.regexPassword, Utils.invalidPassword);
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

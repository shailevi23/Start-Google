package org.example.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;

    public UserController() {
        this.userService = new UserService();
        this.authService = AuthService.getInstance();
    }


    @DeleteMapping("/delete")
        public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String token , @RequestParam("email") String userEmail){
        if(userEmail.equals(this.authService.getTokens().get(token))){
            userService.deleteUser(userEmail);
            return ResponseEntity.ok().build();
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

    @PutMapping("/update/email")
    public ResponseEntity<User> updateUserEmail(@RequestHeader("Authorization") String token,@RequestParam("email") String userEmail,
                                                @RequestParam("newEmail") String newEmail){
        if(userEmail.equals(this.authService.getTokens().get(token))){
            return ResponseEntity.ok(userService.updateUserEmail(userEmail,newEmail));
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

    @PutMapping("/update/username")
    public ResponseEntity<?> updateUserName(@RequestHeader("Authorization") String token , @RequestParam("email") String userEmail,
                                            @RequestParam("newName")  String newName){
        if(userEmail.equals(this.authService.getTokens().get(token))) {
            return ResponseEntity.ok(userService.updateUserName(userEmail, newName));
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    @PutMapping("/update/password")
    public ResponseEntity<User> updateUserPassword(@RequestHeader("Authorization") String token , @RequestParam("email") String userEmail,
                                                   @RequestParam("password") String newPassword){
        if(userEmail.equals(this.authService.getTokens().get(token))){
            return ResponseEntity.ok(userService.updateUserPassword(userEmail,newPassword));
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

}

package org.example.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    public UserController() {
        this.userService = new UserService();
    }


    @DeleteMapping("/delete/{email}")
        public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String token , @PathVariable String userEmail){
        if(checkToken(token, userEmail)){
            userService.deleteUser(userEmail);
            return ResponseEntity.ok().build();
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

    @PutMapping("/update/email/{email}")
    public ResponseEntity<User> updateUserEmail(@RequestHeader("Authorization") String token, String userEmail, String newEmail){
        if(checkToken(token, userEmail)){
            return ResponseEntity.ok(userService.updateUserEmail(userEmail,newEmail));
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

    @PutMapping("/update/username/{email}")
    public ResponseEntity<?> updateUserName(@RequestHeader("Authorization") String token , String userEmail, String newName){
        if(checkToken(token, userEmail)){
            User user = userService.updateUserName(userEmail,newName);
            return ResponseEntity.ok().build();
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    @PutMapping("/update/password/{email}")
    public ResponseEntity<User> updateUserPassword(@RequestHeader("Authorization") String token ,String userEmail,String newPassword){
        if(checkToken(token, userEmail)){
            return ResponseEntity.ok(userService.updateUserPassword(userEmail,newPassword));
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }

    public boolean checkToken(String token ,String userEmail){
        return AuthService.getInstance().getTokens().get(token).equals(userEmail);
    }
}

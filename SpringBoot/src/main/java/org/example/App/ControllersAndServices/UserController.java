package org.example.App.ControllersAndServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    public UserController() {
        this.userService = new UserService();
    }

    public void deleteUser(String token, String userEmail){
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            userService.deleteUser(userEmail);
            System.out.println("the user with email : "+userEmail+" deleted successfully ");
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserEmail(String token,String userEmail, String newEmail ){
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            User user = userService.updateUserEmail(userEmail,newEmail);
            if(user != null){
                System.out.println("User email updated from "+userEmail +" to "+newEmail);
            }
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserName(String token,String userEmail,String newName){
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            User user = userService.updateUserName(userEmail,newName);
            if(user != null){
                System.out.println("User's name updated to "+newName);
            }
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserPassword(String token,String userEmail,String newPassword){
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            User user = userService.updateUserPassword(userEmail,newPassword);
            if(user != null){
                System.out.println("User password has been updated successfully:)");
            }
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
}

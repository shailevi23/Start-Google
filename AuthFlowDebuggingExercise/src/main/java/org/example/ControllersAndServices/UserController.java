package org.example.ControllersAndServices;

import com.sun.javafx.tools.packager.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
    private static Logger logger = LogManager.getLogger(Main.class.getName());
    UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void deleteUser(String token, String userEmail){
        logger.info("tries to delete the user: " + userEmail);
        logger.debug(token, userEmail);
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            userService.deleteUser(userEmail);
            logger.info("the user with email : " + userEmail + " deleted successfully ");
            return;
        }
        logger.error("Incorrect token or email!, Can't delete the user");
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserEmail(String token, String userEmail, String newEmail ){
        logger.info("tries to update user email: " + userEmail + "with new email: " + newEmail);
        logger.debug(token, userEmail, newEmail);
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            userService.updateUserEmail(userEmail,newEmail);
            System.out.println("User email updated from "+userEmail +" to "+newEmail);
            return;
        }
        logger.error("Incorrect token or email!, can't update email");
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserName(String token,String userEmail,String newName){
        logger.info("tries to update user name: email- " + userEmail + "with new name: " + newName);
        logger.debug(token, userEmail, newName);
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            userService.updateUserName(userEmail,newName);
            logger.info("User's name updated to "+newName);
            return;
        }
        logger.error("Incorrect token or email!, can't update user name");
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserPassword(String token,String userEmail,String newPassword){
        logger.info("tries to update user password: email- " + userEmail + "with new name: " + newPassword);
        logger.debug(token, userEmail, newPassword);
        if(AuthService.getInstance().getTokens().get(token).equals(userEmail)){
            userService.updateUserPassword(userEmail,newPassword);
            logger.info("User password has been updated successfully:)");
            return;
        }
        logger.error("Incorrect token or email!, can't update password");
        throw new IllegalArgumentException("Incorrect token or email!");
    }
}

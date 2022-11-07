package org.example.App.ControllersAndServices;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void deleteUser(String token, String userEmail){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userService.deleteUser(userEmail);
            System.out.println("the user with email : "+userEmail+" deleted successfully ");
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserEmail(String token,String userEmail, String newEmail ){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userService.updateUserEmail(userEmail,newEmail);
            System.out.println("User email updated from "+userEmail +" to "+newEmail);
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserName(String token,String userEmail,String newName){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userService.updateUserName(userEmail,newName);
            System.out.println("User's name updated to "+newName);
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserPassword(String token,String userEmail,String newPassword){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userService.updateUserPassword(userEmail,newPassword);
            System.out.println("User password has been updated successfully:)");
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
}

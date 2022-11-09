package org.example;

import com.sun.javafx.tools.packager.Main;
import org.example.ControllersAndServices.AuthController;
import org.example.ControllersAndServices.UserController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static Logger logger = LogManagaer.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String email = "shai@gmail.com";
        String userName = "ShaiLevi";
        String password = "myPasswordIsGreat23#";

        new AuthController().createNewUser(userName,email,password);
        String token = new AuthController().userLogin(email, password);
        UserController userController = new UserController();
        userController.updateUserPassword(token,email,"iChangedMyPassword");
        userController.updateUserName(token,email,"levi");
        userController.updateUserEmail(token,email,"levilevi@gmail.com");

        //incorrect token in purpose
        userController.deleteUser(token,"levilevi@gmail.com");

    }
}

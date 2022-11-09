package org.example.App.ControllersAndServices;

import org.example.App.Utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private final UserRepo userRepo;
    private final Map<String,String> tokens;
    private static AuthService singaleInistance = null;


    AuthService() {
        this.tokens = new HashMap<>();
        this.userRepo = new UserRepo();
    }

    String validateUserLogin(String userEmail, String userPassword) {
        Map<String, User> usersData = this.userRepo.getUsersData();
        if(usersData.get(userEmail) != null)
            if(usersData.get(userEmail).getPassword().equals(userPassword)){
                String token = Utility.RandomString(5);
                tokens.put(token,userEmail);
                System.out.println("The user has logged in successfully:)");
                return token;
            }
        throw new IllegalArgumentException("Email or password is illegal!!");
    }

    String validateUserRegister(User user) {
        Map<String,User> usersData = this.userRepo.getUsersData();
        if(!usersData.isEmpty()) {
            if (usersData.get(user.getEmail()) == null) {
                this.userRepo.saveNewUser(user);
                    System.out.println("The user has registered successfully");
                    return validateUserLogin(user.getEmail(), user.getPassword());
            }
            else{
                throw new IllegalArgumentException("Email has been used!");
            }
        }
        else{
            this.userRepo.saveNewUser(user);
            return validateUserLogin(user.getEmail(), user.getPassword());
        }
    }
    static AuthService getInstance(){
        if(singaleInistance==null)
            singaleInistance = new AuthService();
        return singaleInistance;
    }

    public Map<String, String> getTokens() {
        return tokens;
    }
}

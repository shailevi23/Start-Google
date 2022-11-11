package org.example.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private final UserRepo userRepo;
    Map<String, User> map;



    public UserService() {
        this.map = new HashMap<>();
        this.userRepo = new UserRepo();
    }

    private User isUser(String userEmail){
        Map<String, User> usersData = this.userRepo.getUsersData();
        User userExists = usersData.get(userEmail);
        if (userEmail == null)
            throw new IllegalArgumentException("User doesn't exists");
        else
            return userExists;
    }

    private boolean isEmailExist(String userEmail){
        Map<String, User> usersData = this.userRepo.getUsersData();
        User userExists = usersData.get(userEmail);
        return userExists != null;
    }
    void deleteUser(String userEmail){
        User userExists = isUser(userEmail);
        this.userRepo.deleteUser(userExists);
    }

    User updateUserEmail(String userEmail , String newEmail){
        if(isEmailExist(newEmail)){
            throw new IllegalArgumentException("User already registered with this email");
        }
        User userExists = isUser(userEmail);
        userExists.setEmail(newEmail);
        this.userRepo.updateUserEmail(userEmail,userExists);
        return userExists;
    }
    User updateUserName(String userEmail , String userName){
        User userExists = isUser(userEmail);
        userExists.setName(userName);
        userRepo.updateUser(userExists);
        return userExists;
    }
    User updateUserPassword(String userEmail , String userPassword){
        User userExists = isUser(userEmail);
        userExists.setPassword(userPassword);
        this.userRepo.updateUser(userExists);
        return userExists;
    }
}

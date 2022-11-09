package org.example.App.ControllersAndServices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepo {

    private Gson gson = null;
    private File file;
    private Map<String, User> usersData;


    public UserRepo() {
        gson = new Gson();
        usersData = new HashMap<>();
        createUsersFile();
        readUsersData();
    }

    private void createUsersFile(){
        try {
            file = new File("./users.json");
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Something went wrong, database file not found", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile() {
        try(FileOutputStream fileOut = new FileOutputStream("users.json")) {
            System.out.println(usersData);
            fileOut.write(gson.toJson(usersData).getBytes());
            fileOut.flush();
        }
        catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }

    void saveNewUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    void updateUserEmail(String oldEmail,User user){
        usersData.remove(oldEmail);
        updateUser(user);
    }
    void updateUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    void deleteUser(User user){
        usersData.remove(user.getEmail(), user);
        writeToFile();
    }

    Map<String, User> getUsersData(){
        return usersData;
    }


    private void readUsersData() {
        try{
            String result = new String(Files.readAllBytes(Paths.get("./users.json")));
            Map<String,User> map = gson.fromJson(result, new TypeToken<HashMap<String, User>>() {}.getType());
            if(map != null){
                usersData = map;
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }
}

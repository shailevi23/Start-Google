package org.example.ControllersAndServices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.javafx.tools.packager.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private static Logger logger = LogManager.getLogger(Main.class.getName());


    private static Gson gson = null;
    private static File file;
    private static Map<String, User> usersData;


    private UserRepo() {
    }

    static void initUserRepo(){
        gson = new Gson();
        usersData = new HashMap<>();
        createUsersFile();
        readUsersData();
    }

    private static void createUsersFile(){
        try {
            logger.info("loading the file or creating new");
            file = new File("./users.json");
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (NullPointerException e) {
            logger.error("Something went wrong, database file not found", e);
            throw new RuntimeException("Something went wrong, database file not found", e);
        } catch (IOException e) {
            logger.error("Something went wrong, runtime exception", e);
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile() {
        try(FileOutputStream fileOut = new FileOutputStream("users.json")) {
            logger.info("writing to file");
            System.out.println(usersData);
            fileOut.write(gson.toJson(usersData).getBytes());
            fileOut.flush();
        }
        catch (IOException e) {
            logger.error("Can't write to file", e);
            throw new RuntimeException("Can't write to file", e);
        }
    }

    static void saveNewUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    static void updateUserEmail(String oldEmail,User user){
        usersData.remove(oldEmail);
        updateUser(user);
    }
    static void updateUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    static void deleteUser(User user){
        usersData.remove(user.getEmail(), user);
        writeToFile();
    }

    static Map<String, User> getUsersData(){
        return usersData;
    }


    private static void readUsersData() {
        try{
            logger.info("reading from file");
            String result = new String(Files.readAllBytes(Paths.get("./users.json")));
            Map<String,User> map = gson.fromJson(result, new TypeToken<HashMap<String, User>>() {}.getType());
            if(map != null){
                usersData = map;
            }
        }
        catch (IOException e) {
            logger.error("Can't read from file", e);
            throw new RuntimeException("Can't read from file", e);
        }
    }
}

package org.example.Utils;

import java.util.Random;

public class NameGenerator {

    private final String[] firstName;
    private final String[] lastName;

    public NameGenerator(String[] firstName, String[] lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getRandFirstName(String[] firstName){
        int index = getRandomIndex(firstName.length);
        return firstName[index];
    }

    public String getRandLastName(String[] lastName){
        int index = getRandomIndex(lastName.length);
        return lastName[index];
    }

    public String generatePlayerName(){
        return getRandFirstName(this.firstName) + " " + getRandLastName(this.lastName);
    }

    public static int getRandomIndex(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }
}
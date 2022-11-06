package org.example;

import org.example.App.Farmer;

public class Main {
    public static void main(String[] args) {
        Farmer farmer = Farmer.newFarmer();

        for (int i = 0; i < 10; i++) {
            farmer.createRandomAnimal();
        }

        for (int i = 0; i < 10; i++) {
            farmer.animalMove(farmer.requestAnimal());
        }

        farmer.checkAnimalMating(farmer.requestAnimal());

    }
}
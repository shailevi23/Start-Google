package org.example;

import org.example.App.*;

public class Main {
    public static void main(String[] args) {
        Farmer farmer = Farmer.newFarmer();

        Horse horse = farmer.createHorseAnimal();
        WoodenStructures woodenHorse = new WoodenHorse();
        WoodenStructures woodenHorseAdapter = new WoodenStructureAdapter(horse);

        System.out.println("Horse:");
        horse.roll();
        horse.replicate();

        System.out.println("woodenHorse:");
        woodenHorse.roll();
        woodenHorse.replicate();

        System.out.println("woodenHorseAdapter:");
        woodenHorseAdapter.roll();
        woodenHorseAdapter.replicate();

    }
}
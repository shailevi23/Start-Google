package org.example;

import org.example.App.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    public static void main(String[] args) {
        Farmer farmer = Farmer.newFarmer();

        Horse horse = farmer.createHorseAnimal();
        WoodenStructures woodenHorse = new WoodenHorse();
        WoodenStructureAdapter woodenHorseAdapter = new WoodenStructureAdapter(woodenHorse);

        System.out.println("woodenHorse:");
        woodenHorseAdapter.move();
        System.out.println(woodenHorseAdapter.mate(horse));

    }

}
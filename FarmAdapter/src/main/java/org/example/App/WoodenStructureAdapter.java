package org.example.App;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;

public class WoodenStructureAdapter implements Animal{
    private WoodenStructures woodenStructures;
    private static Logger logger = LogManager.getLogger(Main.class.getName());

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        logger.fatal("animal move went wrong");
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal animal) {
        logger.info("mate happened");
        return new WoodenStructureAdapter(woodenStructures.replicate());
    }

    @Override
    public void setGender(Gender gender) {

    }

    @Override
    public void setWeight(int weight) {

    }

    @Override
    public void setId(int id) {

    }

    @Override
    public Gender getGender() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public String toString() {
        return woodenStructures.toString();
    }
}

package org.example.App;

public class Farmer {

    Farm farm;
    private Farmer(){
    }

    public static Farmer newFarmer(){
        Farmer farmer = new Farmer();
        farmer.setFarm(Farm.newFarm());
        return farmer;
    }

    private void setFarm(Farm newFarm) {
        this.farm = newFarm;
    }

    public void animalMove(Animal animal){
        System.out.print(animal.toString() + " \n");
        animal.move();
    }

    public Animal requestAnimal(){
        return this.farm.getRandomAnimal();
    }

    public void createRandomAnimal(){
        this.farm.acquire();
    }

    public boolean checkAnimalMating(Animal animal){
        return this.farm.mateNewAnimal(animal);
    }
}

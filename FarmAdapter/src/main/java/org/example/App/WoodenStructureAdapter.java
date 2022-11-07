package org.example.App;

public class WoodenStructureAdapter implements Animal{
    private WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal animal) {
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

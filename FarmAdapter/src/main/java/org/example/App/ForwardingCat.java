package org.example.App;

class ForwardingCat implements Animal{

    private Cat cat;
    private final Gender gender;
    private final int weight;
    private final int id;

    public ForwardingCat( int id, int weight, Gender gender){
        cat = Cat.newCat(id,weight,gender);
        this.gender = gender;
        this.weight = weight;
        this.id = id;
    }

    @Override
    public void move() {
        cat.move();
    }

    @Override
    public Animal mate(Animal animal) {
        cat.mate(animal);
        return cat;
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
}

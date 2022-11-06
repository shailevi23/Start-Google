package org.example.App;

abstract class AbstractAnimal implements Animal {

    int id;
    int weight;
    Gender gender;

    @Override
    public void move() {
        System.out.println("Move");
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}

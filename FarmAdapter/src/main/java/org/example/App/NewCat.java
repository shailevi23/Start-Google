package org.example.App;

public class NewCat extends ForwardingCat{
    public NewCat(Cat cat){
        super(cat.id, cat.weight, cat.gender);
    }

    public static NewCat copyOf(NewCat newCat){
        return new NewCat(Cat.newCat(newCat.getId(), newCat.getWeight(), newCat.getGender()));
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public Animal mate(Animal animal) {
        return super.mate(animal);
    }

    @Override
    public String toString() {
        return "Forwarding cat";
    }
}

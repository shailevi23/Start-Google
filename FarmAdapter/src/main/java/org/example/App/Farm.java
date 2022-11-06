package org.example.App;

import java.util.ArrayList;
import java.util.Iterator;

class Farm {

    enum AnimalType{Cat, Dog, Horse};
    ArrayList<Animal> animalList;

    private Farm(){
    }

    static Farm newFarm(){
        Farm farm = new Farm();
        ArrayList<Animal> animals = new ArrayList<>();
        farm.setAnimalList(animals);
        return farm;
    }

    void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    Animal getRandomAnimal(){
        Animal animal =  animalList.get(Generator.randomInt(0,animalList.size()));
        if(animal instanceof Horse){
            return Horse.copyOf((Horse) animal);
        }
        if(animal instanceof Dog) {
            return Dog.copyOf((Dog) animal);
        }
        if(animal instanceof NewCat) {
            return NewCat.copyOf((NewCat) animal);
        }
        else {
            return Cat.copyOf((Cat) animal);
        }
    }

    void acquire(){
        int randomAnimal = Generator.randomInt(0,4);

        if(randomAnimal == 0) {
            this.animalList.add(Dog.newDog(Generator.randomInt(0, 100), Generator.randomInt(0, 100), Generator.randomGender()));
        }
        if(randomAnimal == 1) {
            this.animalList.add(Horse.newHorse(Generator.randomInt(0, 100), Generator.randomInt(0, 100), Generator.randomGender()));
        }
        if(randomAnimal == 2) {
            this.animalList.add(Cat.newCat(Generator.randomInt(0, 100), Generator.randomInt(0, 100), Generator.randomGender()));
        }
        if(randomAnimal == 3) {
            this.animalList.add(new NewCat(Cat.newCat(Generator.randomInt(0, 100), Generator.randomInt(0, 100), Generator.randomGender())));
        }
    }

    boolean mateNewAnimal(Animal animal){
        boolean res = false;
        Iterator i = animalList.iterator();
        while (i.hasNext() && !res) {
            if(!res) {
                res = checkIfTheSameAnimal(animal, (Animal) i.next());
            }
            else{
                return true;
            }
        }
        return false;
    }

    boolean checkIfTheSameAnimal(Animal animalOne, Animal animalTwo){
        if(animalOne.getGender() != animalTwo.getGender()){
            if(animalOne instanceof Dog && animalTwo instanceof Dog) {
                this.animalList.add(animalTwo.mate(animalOne));
                return true;
            }
            if(animalOne instanceof Horse && animalTwo instanceof Horse){
                this.animalList.add(animalTwo.mate(animalOne));
                return true;
            }
          if(animalOne instanceof Cat && animalTwo instanceof Cat){
                this.animalList.add(animalTwo.mate(animalOne));
                return true;
          }
        }
        return false;
    }
}

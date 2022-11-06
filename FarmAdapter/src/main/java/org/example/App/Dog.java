package org.example.App;

class Dog extends AbstractAnimal{
    private Dog() {
    }

    static Dog newDog(int id, int weight, Gender gender){
        Dog dog = new Dog();
        dog.setId(id);
        dog.setWeight(weight);
        dog.setGender(gender);
        return dog;
    }

    static Dog copyOf(Dog dog){
        return Dog.newDog(dog.id, dog.weight, dog.gender);
    }

    @Override
    public Dog mate(Animal partner) {
        Dog dog = newDog(Generator.randomInt(1, 100),
                Generator.randomInt(1, 100), Generator.randomGender());
        System.out.println(dog + " Mazal Tov, New Dog!" );
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}

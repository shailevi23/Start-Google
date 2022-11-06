package org.example.App;

class Cat extends AbstractAnimal{

    private Cat(){

    }

    static Cat newCat(int id, int weight, Gender gender){
        Cat cat = new Cat();
        cat.setId(id);
        cat.setWeight(weight);
        cat.setGender(gender);
        return cat;
    }

    static Cat copyOf(Cat cat){
        return Cat.newCat(cat.id, cat.weight, cat.gender);
    }

    @Override
    public Cat mate(Animal partner) {
        Cat cat =  newCat(Generator.randomInt(1, 100),
                Generator.randomInt(1, 100), Generator.randomGender());
        System.out.println(cat + " Mazal Tov, New Cat!" );
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + super.getId() +
                ", weight=" + super.getWeight() +
                ", gender=" + super.getGender() +
                '}';
    }
}

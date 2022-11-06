package org.example.App;

public class Horse extends AbstractAnimal{

    private Horse() {
    }

    public static Horse newHorse(int id, int weight, Gender gender){
        Horse horse = new Horse();
        horse.setId(id);
        horse.setWeight(weight);
        horse.setGender(gender);
        return horse;
    }

    public static Horse copyOf(Horse horse){
        return Horse.newHorse(horse.id, horse.weight, horse.gender);
    }

    @Override
    public Horse mate(Animal partner) {
        Horse horse = newHorse(Generator.randomInt(1,100),
                Generator.randomInt(1,100), Generator.randomGender());
        System.out.println(horse + " Mazal Tov, New Horse!" );
        return horse;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
}

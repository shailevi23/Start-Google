package org.example.App;

interface Animal {
    void move();
    void roll();
    void replicate();
    Animal mate(Animal animal);

    void setGender(Gender gender);

    void setWeight(int weight);

    void setId(int id);

    enum Gender{Male, Female}

    Gender getGender();
    int getId();
    int getWeight();




}

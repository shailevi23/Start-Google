package org.example.App;

class Generator {

    public static int randomInt(int num1, int num2){
        return (int) ((Math.random() * (Math.max(num1, num2) - Math.min(num1, num2))) + Math.min(num1, num2));
    }

    public static Animal.Gender randomGender(){
        int rand = randomInt(0,2);
        return rand == 0 ? Animal.Gender.Male : Animal.Gender.Female;
    }

}

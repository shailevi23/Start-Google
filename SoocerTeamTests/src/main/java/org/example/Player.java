package org.example;

enum Position {
    GK,
    DEF,
    MID,
    ATK
}

public class Player {
    String name;
    int jersey;
    int grade;
    Position pos;


    private Player() {
    }

    public static Player deafultPLayer(String name,  int jersey, int grade, Position pos) {
        Player player = new Player();
        player.setGrade(grade);
        player.setJersey(jersey);
        player.setName(name);
        player.setPos(pos);
        return player;
    }

    public static Player mainStriker(String name, int grade) {
        Player player = new Player();
        player.setGrade(grade);
        player.setJersey(9);
        player.setName(name);
        player.setPos(Position.ATK);
        return player;
    }

    public static Player mainGoalkeeper(String name, int grade) {
        Player player = new Player();
        player.setGrade(grade);
        player.setJersey(1);
        player.setName(name);
        player.setPos(Position.GK);
        return player;
    }
    public static Player bestPlayer(String name,  int jersey, Position pos) {
        Player player = new Player();
        player.setGrade(10);
        player.setJersey(jersey);
        player.setName(name);
        player.setPos(pos);
        return player;
    }

    public static Player noNamePlayer(int jersey, int grade, Position pos) {
        Player player = new Player();
        player.setGrade(grade);
        player.setJersey(jersey);
        player.setName("");
        player.setPos(pos);
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new NullPointerException("name cannot be null");
        }
        this.name = name;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        if(jersey < 0 || jersey > 99){
            throw new IllegalArgumentException("jersey number not valid");
        }
        this.jersey = jersey;
    }

    public int getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", jersey=" + jersey +
                ", grade=" + grade +
                ", position=" + pos +
                '}';
    }

    public void setGrade(int grade) {
        if(grade < 0 || grade > 10){
            throw new IllegalArgumentException("grade between 0 to 10");
        }
        this.grade = grade;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        if(pos == null){
            throw new NullPointerException("position cannot be null");
        }
        this.pos = pos;
    }
}


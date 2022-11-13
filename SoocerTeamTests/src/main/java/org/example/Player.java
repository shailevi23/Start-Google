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
    public static Player bestPlayer(String name,  int jersey, int grade, Position pos) {
        Player player = new Player();
        player.setGrade(5);
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
        this.name = name;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
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
        this.grade = grade;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}


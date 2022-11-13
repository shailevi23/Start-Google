package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Team {
    ArrayList<Player> players;
    ArrayList<Position> formation;
    String teamName;

    ArrayList<Integer> jerseyNumbers;

    private Team() {
        createJerseyNumbers();
    }

    public ArrayList<Position> getFormation() {
        return formation;
    }

    public void setFormation(ArrayList<Position> formation) {
        this.formation = formation;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        if(players == null){
            throw new NullPointerException("Players list is null");
        }
        this.players = players;
    }

    public ArrayList<Integer> getJerseyNumbers() {
        return jerseyNumbers;
    }

    public void setJerseyNumbers(ArrayList<Integer> jerseyNumbers) {
        this.jerseyNumbers = jerseyNumbers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if(teamName == null){
            throw new NullPointerException("Team name cannot be null");
        }

        if(teamName.equals("")){
            throw new IllegalArgumentException("Team name cannot be empty");
        }

        this.teamName = teamName;
    }

    public static final Team teamFormationOneFourFourTwo(String teamName){
        Team team = new Team();
        team.setPlayers(new ArrayList<Player>());
        team.setTeamName(teamName);
        team.setFormation(new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK, Position.ATK)));
        return team;
    }

    public static final Team teamFormationOneFiveFourOne(String teamName){
        Team team = new Team();
        team.setPlayers(new ArrayList<Player>());
        team.setTeamName(teamName);
        team.setFormation(new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK)));
        return team;
    }

    public static final Team teamFormationOneThreeFourThree(String teamName){
        Team team = new Team();
        team.setPlayers(new ArrayList<Player>());
        team.setTeamName(teamName);
        team.setFormation(new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK, Position.ATK, Position.ATK)));
        return team;
    }

    private void createJerseyNumbers(){
        jerseyNumbers = new ArrayList<>();
        for (int i = 1; i <= 99; i++)
        {
            jerseyNumbers.add(i);
        }
        Collections.shuffle(jerseyNumbers); //to diversify and get multiple teams on output
    }

    public static void writeTeamDataToFile(Team team) {
        try (FileOutputStream fos = new FileOutputStream("mytxt.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(team.toString());

            oos.close();
            fos.close();
            System.out.println("File Written Successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                ", name='" + teamName + '\'' +
                '}';
    }

}

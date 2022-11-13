package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    ArrayList<Player> players;
    ArrayList<Position> formation;
    String teamName;

    private Team() {
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
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
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

    public static final Team teamFormationOneThreeFourThree(ArrayList<Player> playersList, String teamName){
        Team team = new Team();
        team.setPlayers(playersList);
        team.setTeamName(teamName);
        team.setFormation(new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK, Position.ATK, Position.ATK)));
        return team;
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

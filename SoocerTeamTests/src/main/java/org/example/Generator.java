package org.example;

import org.example.Utils.NameGenerator;
import org.example.Utils.NamesData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Generator {

    static NamesData namesData = new NamesData();
    static NameGenerator nameGenerator = new NameGenerator(namesData.firstNamesDataList(), namesData.lastNamesDataList());

    public static void createSoccerTeam(Team team, int teamSize){

        ArrayList<String> playerNames = new ArrayList<>();
        //init
        createPlayerNames(playerNames, teamSize);
        createPlayerPositionsArray(team.getFormation(), teamSize);

        ArrayList<Position> positionsList = team.getFormation();

        for (int i = 0; i < teamSize; i++) {
            team.players.add(createPlayer(team.getJerseyNumbers(), team.getFormation(), playerNames));
        }

        team.setFormation(positionsList);
    }

    private static Player createPlayer(ArrayList<Integer> jerseyNumbersList,
                                       ArrayList<Position> positionsList, ArrayList<String> playerNames){

        return Player.deafultPLayer(retValAndRmFromList(playerNames),
                retValAndRmFromList(jerseyNumbersList), randomInt(10), retValAndRmFromList(positionsList));
    }

    private static void createPlayerNames(ArrayList<String> playerNames, int teamSize){

        for (int i = 0; i < teamSize; i++) {
            playerNames.add(nameGenerator.generatePlayerName());
        }
    }

    private static <T> T retValAndRmFromList(ArrayList<T> list){
        Collections.shuffle(list); //to diversify and get multiple teams every output
        T res = list.get(0); //get first index name
        list.remove(0); //remove first index to avoid duplicates
        return res;
    }


    private static void createPlayerPositionsArray(ArrayList<Position> playerPositions, int teamSize){
        if(playerPositions.isEmpty()) {
            playerPositions.addAll(Arrays.asList(Position.GK, Position.DEF, Position.DEF, Position.MID, Position.MID, Position.ATK, Position.ATK));
            Position[] positionOptions = {Position.DEF, Position.MID, Position.ATK};
            int size = teamSize - playerPositions.size();

            for (int i = 1; i <= size; i++) {
                playerPositions.add(positionOptions[randomInt(positionOptions.length) - 1]);
            }
            Collections.shuffle(playerPositions); //to diversify and get multiple teams on output
        }
    }

    public static int randomInt(int bound){
        Random random = new Random();
        return random.nextInt(bound) + 1;
    }
}

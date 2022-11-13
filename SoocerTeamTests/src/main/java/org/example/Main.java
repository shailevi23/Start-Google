package org.example;

import org.example.Utils.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Team builtInFormationTeam = Team.teamFormationOneFiveFourOne("Barcelona");
        Generator.createSoccerTeam(builtInFormationTeam, 11);

        for (Player player : builtInFormationTeam.getPlayers()){
            System.out.println(player.toString());
        }

        Team.writeTeamDataToFile(builtInFormationTeam);
    }
}
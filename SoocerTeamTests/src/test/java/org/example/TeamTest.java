package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    Team team = Team.teamFormationOneFiveFourOne("barcelona");

    @Test
    void getFormation_formation1541_isEquals() {
        ArrayList<Position> positionList = new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK));

        assertArrayEquals(team.getFormation().toArray(), positionList.toArray());
    }

    @Test
    void setFormation_changeFrom1541ToFormation1442_isEquals() {
        ArrayList<Position> positionList = new ArrayList<> (Arrays.asList(
                Position.GK,
                Position.DEF, Position.DEF, Position.DEF, Position.DEF,
                Position.MID, Position.MID, Position.MID, Position.MID,
                Position.ATK, Position.ATK));
        team.setFormation(positionList);
        assertArrayEquals(team.getFormation().toArray(), positionList.toArray());
    }

    @Test
    void getPlayers_playersListNotNull_isNotNull() {
        Generator.createSoccerTeam(team,11);
        assertNotNull(team.getPlayers());
    }

    @Test
    void setPlayers() {
    }

    @Test
    void getTeamName() {
    }

    @Test
    void setTeamName() {
    }

    @Test
    void teamFormationOneFourFourTwo() {
    }

    @Test
    void teamFormationOneFiveFourOne() {
    }

    @Test
    void teamFormationOneThreeFourThree() {
    }

}
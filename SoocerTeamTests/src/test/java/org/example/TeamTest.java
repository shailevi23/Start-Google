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
    void setPlayers_playersSetNull_throwsException() {
        assertThrows(NullPointerException.class, () -> team.setPlayers(new ArrayList<>(Arrays.asList(null))), "expected NullPointerException and other exception was thrown");
    }

    @Test
    void getTeamName_nameIsBarcelona_isEquals() {
        assertEquals(team.getTeamName(), "barcelona");
    }

    @Test
    void setTeamName_teamNameNull_throwException() {
        assertThrows(NullPointerException.class, () -> team.setTeamName(null), "expected NullPointerException and other exception was thrown");
    }

    @Test
    void setTeamName_teamNameEmpty_throwException() {
        assertThrows(IllegalArgumentException.class, () -> team.setTeamName(""), "expected IllegalArgumentException and other exception was thrown");
    }

    @Test
    void teamFormationOneFourFourTwo_teamNotNull_isNotNull() {
        Team team = Team.teamFormationOneFourFourTwo("barcelona");
        assertNotNull(team);
    }

    @Test
    void teamFormationOneFiveFourOne() {
        Team team = Team.teamFormationOneFiveFourOne("barcelona");
        assertNotNull(team);
    }

    @Test
    void teamFormationOneThreeFourThree() {
        Team team = Team.teamFormationOneThreeFourThree("barcelona");
        assertNotNull(team);
    }

}
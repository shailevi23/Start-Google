package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = Player.deafultPLayer("name", 10,5,Position.GK);


    @Test
    void mainStriker_positionIsAtk_isEqualsToAtk() {
        Player player = Player.mainStriker("name", 5);
        assertEquals(player.getPos(), Position.ATK);
    }

    @Test
    void mainStriker_jerseyNumIs9_isEqualsTo9() {
        Player player = Player.mainStriker("name", 5);
        assertEquals(player.getJersey(), 9);
    }

    @Test
    void mainGoalkeeper_jerseyNumIs1_isEqualsTo1() {
        Player player = Player.mainGoalkeeper("name", 5);
        assertEquals(player.getJersey(), 1);
    }

    @Test
    void mainGoalkeeper_positionIsGK_isEqualsToGK() {
        Player player = Player.mainGoalkeeper("name", 5);
        assertEquals(player.getPos(), Position.GK);
    }

    @Test
    void bestPlayer_gradeIs10_isEquals() {
        Player player = Player.bestPlayer("name", 10, Position.DEF);
        assertEquals(player.getGrade(), 10);
    }

    @Test
    void noNamePlayer_nameIsNone_isEquals() {
        Player player = Player.noNamePlayer(10,5,Position.GK);
        assertEquals(player.getName(), "");
    }

    @Test
    void getName_nameIsName_isEquals() {
        assertEquals(player.getName(), "name");
    }

    @Test
    void setName_nameIsNull_throwsException() {
        assertThrows(NullPointerException.class, () -> player.setName(null), "expected NullPointerException and other exception was thrown");
    }

    @Test
    void setName_validName_isEquals() {
        player.setName("newName");
        assertEquals(player.getName(),"newName");
    }

    @Test
    void getJersey_jerseyIs10_isEquals() {
        assertEquals(player.getJersey(), 10);
    }

    @Test
    void setJersey_negativeJersey_throwException() {
        assertThrows(IllegalArgumentException.class, () -> player.setJersey(-1), "expected IllegalArgumentException and other exception was thrown");
    }

    @Test
    void getGrade_gradeIs5_isEquals() {
        assertEquals(player.getGrade(), 5);
    }


    @Test
    void setGrade_negativeGrade_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> player.setGrade(-1), "expected IllegalArgumentException and other exception was thrown");
    }

    @Test
    void setGrade_validGrade_isEquals() {
        player.setGrade(4);
        assertEquals(player.getGrade(),4);
    }

    @Test
    void getPos_getPositionOfGK_isEqualsGK() {
        assertEquals(player.getPos(), Position.GK);
    }

    @Test
    void setPos_positionNull_throwException() {
        assertThrows(NullPointerException.class, () -> player.setPos(null), "expected NullPointerException and other exception was thrown");
    }

    @Test
    void player_playerWithNegativeJersey_throwException(){
        assertThrows(IllegalArgumentException.class, () -> Player.deafultPLayer("name",-9, 1, Position.DEF), "expected IllegalArgumentException and other exception was thrown");
    }

    @Test
    void player_playerWithNullPosition_throwException(){
        assertThrows(NullPointerException.class, () -> Player.deafultPLayer("name", 1, 8, null), "expected NullPointerException but something else thrown");
    }

}
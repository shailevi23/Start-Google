package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTests {
    private Generator generator;

    @BeforeEach
    void beforeEach(){
        generator = new Generator();
    }

    @Test
    void createSoccerTeam_validTeam_teamNotNull(){
        //Arrange
        Team builtInFormationTeam = Team.teamFormationOneFiveFourOne("Barcelona");
        //Act
        Generator.createSoccerTeam(builtInFormationTeam, 11);
        //Assert
        assertNotNull(builtInFormationTeam);
    }

    @Test
    void createPlayerNames_randomNamesList_playersListNotNull(){
        //Arrange
        Team builtInFormationTeam = Team.teamFormationOneFiveFourOne("Barcelona");
        //Act
        Generator.createSoccerTeam(builtInFormationTeam, 11);
        //Assert
        assertNotNull(builtInFormationTeam.getPlayers());

    }


}

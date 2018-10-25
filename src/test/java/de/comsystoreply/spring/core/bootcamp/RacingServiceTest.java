package de.comsystoreply.spring.core.bootcamp;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest {

    private Racing service;

    @BeforeEach
    void setUp() {
        service = new RacingService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRacingTeam() {
        final RacingTeam banana = service.createRacingTeam("Banana");
        Assert.assertNotNull(banana);
        Assert.assertEquals("Banana", banana.getName());

    }

    @Test
    void createRacingTeam_nonDuplicateName() {

        final RacingTeam banana = service.createRacingTeam("Banana");

        assertThrows(TeamAlreadyExistsException.class, () -> service.createRacingTeam("Banana"));


    }

    @Test
    void deleteRacingTeamByName() {

        RacingTeam banana = service.createRacingTeam("Banana");

        service.deleteRacingTeamByName(banana.getName());

        Assert.assertEquals(0, service.getAllRacingTeams().size());
    }

    @Test
    void modifyTeamByName_teamIsPresent() {
        service.createRacingTeam("Tomato");
        RacingTeam result = service.modifyTeamByName("Tomato", "Cucumber");

        Assert.assertEquals("Cucumber", result.getName());
    }

    @Test
    void modifyTeamByName_teamIsNotPresent() {

        assertThrows(IllegalArgumentException.class,
                () -> service.modifyTeamByName("Tomato", "Cucumber"));


    }

    @Test
    void getRacingTeamByName() {
        final RacingTeam expected = service.createRacingTeam("Tomato");
        Optional<RacingTeam> tomato = service.getRacingTeamByName("Tomato");
        Assert.assertTrue(tomato.isPresent());
        Assert.assertEquals(expected.getName(),tomato.get().getName());
    }

    @Test
    void getAllRacingTeams() {

        service.createRacingTeam("Banana");
        service.createRacingTeam("Apple");

        List<RacingTeam> allRacingTeams = service.getAllRacingTeams();
        Assert.assertEquals(2, allRacingTeams.size());
    }

    @Test
    void deleteAllRacingTeams() {
        service.createRacingTeam("Banana");
        service.createRacingTeam("Apple");

        service.deleteAllRacingTeams();
        Assert.assertTrue(service.getAllRacingTeams().isEmpty());
    }
}
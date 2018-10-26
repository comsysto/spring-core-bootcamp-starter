package de.comsystoreply.spring.core.bootcamp;

import de.comsystoreply.spring.core.bootcamp.data.DataConfiguration;
import de.comsystoreply.spring.core.bootcamp.data.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.services.Racing;
import de.comsystoreply.spring.core.bootcamp.services.RacingService;
import de.comsystoreply.spring.core.bootcamp.services.ServiceConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {ServiceConfiguration.class, DataConfiguration.class})
@Transactional
class RacingServiceTest {

    private Racing service;

    //@Mock
    @Autowired
    private RacingTeamRepository repository;

    @BeforeEach
    void setUp() {
        service = new RacingService(repository);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void createRacingTeam() {
        final RacingTeam banana = service.createRacingTeam("Banana");
        Assert.assertNotNull(banana);
        Assert.assertEquals("Banana", banana.getName());
    }

    @Test
    void createRacingTeam_nonDuplicateName() {

        service.createRacingTeam("Banana");
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
        service.createRacingTeam("Tomato");
        Optional<RacingTeam> tomato = service.getRacingTeamByName("Tomato");
        Assert.assertTrue(tomato.isPresent());
        Assert.assertEquals("Tomato", tomato.get().getName());

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
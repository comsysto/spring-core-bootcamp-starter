package de.comsystoreply.spring.core.bootcamp.adapter.database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import de.comsystoreply.spring.core.bootcamp.ApplicationInitializer;

import static de.comsystoreply.spring.core.bootcamp.TestData.aTeam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationInitializer.class)
@WebAppConfiguration
@Transactional
class TeamRepositoryIntegrationTest {

    @Autowired
    private TeamRepository repository;

    @Test
    void injected() {
        assertNotNull(repository);
    }

    @Test
    void createANewTeam() {
        var original = aTeam();

        var result = repository.create(original);

        assertNotNull(result.getId());
        assertEquals(original.getName(), result.getName());
    }

    @Test
    void findOneTeamById() {
        var searchedTeam = repository.create(aTeam());

        //createMultipleTeams
        repository.create(aTeam());
        repository.create(aTeam());

        var result = repository.findById(searchedTeam.getId());

        assertTrue(result.isPresent());
        assertEquals(searchedTeam, result.get());
    }

    @Test
    void deleteTeam() {
        var team = repository.create(aTeam());

        repository.delete(team);

        var loadedTeam = repository.findById(team.getId());
        assertTrue(loadedTeam.isEmpty());
    }
}

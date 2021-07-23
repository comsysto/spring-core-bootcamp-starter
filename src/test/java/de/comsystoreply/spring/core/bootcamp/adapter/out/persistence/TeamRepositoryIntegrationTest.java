package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static de.comsystoreply.spring.core.bootcamp.TestData.aTeam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceConfig.class)
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
    void updateATeam() {
        var original = repository.create(aTeam());

        var newTeamName = "New even more impressive team name";
        original.setName(newTeamName);
        repository.update(original);

        var loaded = repository.findById(original.getId());

        assertTrue(loaded.isPresent());
        assertEquals(newTeamName, loaded.get().getName());
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
    void findAllTeams() {
        var teamA = repository.create(aTeam());
        var teamB = repository.create(aTeam());
        var teamC = repository.create(aTeam());

        var result = repository.findAll();

        assertEquals(3, result.size());
        assertTrue(result.contains(teamA));
        assertTrue(result.contains(teamB));
        assertTrue(result.contains(teamC));
    }

    @Test
    void deleteTeam() {
        var team = repository.create(aTeam());

        repository.delete(team);

        var loadedTeam = repository.findById(team.getId());
        assertTrue(loadedTeam.isEmpty());
    }
}

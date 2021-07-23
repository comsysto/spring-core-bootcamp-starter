package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;

import static de.comsystoreply.spring.core.bootcamp.TestData.aTeam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamRepositoryIntegrationTest extends PersistenceIntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void injected() {
        assertNotNull(teamRepository);
    }

    @Test
    void createANewTeam() {
        var original = aTeam();

        var result = teamRepository.create(original);
        flushAndClearSession();

        assertNotNull(result.getId());
        assertEquals(original.getName(), result.getName());
        assertEquals(Set.<Driver>of(), result.getDrivers());
    }

    @Test
    void deleteTeam() {
        var team = teamRepository.create(aTeam());

        teamRepository.delete(team);
        flushAndClearSession();

        var loadedTeam = teamRepository.findById(team.getId());
        assertTrue(loadedTeam.isEmpty());
    }

    @Test
    void findOneTeamById() {
        var searchedTeam = teamRepository.create(aTeam());
        teamRepository.create(aTeam());
        teamRepository.create(aTeam());
        flushAndClearSession();

        var result = teamRepository.findById(searchedTeam.getId());

        assertTrue(result.isPresent());
        assertEquals(searchedTeam, result.get());
    }

    @Test
    void findAllTeams() {
        var teamA = teamRepository.create(aTeam());
        var teamB = teamRepository.create(aTeam());
        var teamC = teamRepository.create(aTeam());
        flushAndClearSession();

        var result = teamRepository.findAll();

        assertEquals(3, result.size());
        assertTrue(result.contains(teamA));
        assertTrue(result.contains(teamB));
        assertTrue(result.contains(teamC));
    }

    @Test
    void findTeamByName() {
        var namedTeam = teamRepository.create(aTeam());
        teamRepository.create(aTeam());
        teamRepository.create(aTeam());
        teamRepository.create(aTeam());
        flushAndClearSession();

        var result = teamRepository.findByName(namedTeam.getName());

        assertTrue(result.isPresent());
        assertEquals(namedTeam, result.get());
    }
}

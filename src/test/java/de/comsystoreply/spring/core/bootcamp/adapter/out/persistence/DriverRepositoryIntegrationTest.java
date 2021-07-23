package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.Set;
import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

import static de.comsystoreply.spring.core.bootcamp.TestData.aDriver;
import static de.comsystoreply.spring.core.bootcamp.TestData.aTeam;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DriverRepositoryIntegrationTest extends PersistenceIntegrationTest {

    @Autowired
    private JpaDriverRepository driverRepository;

    @Autowired
    private CrudRepository<Team, Long> teamRepository;

    @Test
    void createDriver() {
        var team = teamRepository.create(aTeam());
        var driver = aDriver();

        driver.setTeam(team);
        var persistentDriver = driverRepository.create(driver);
        flushAndClearSession();

        assertNotNull(persistentDriver.getId());

        var persistentTeam = teamRepository.findById(team.getId());
        assertTrue(persistentTeam.isPresent());
        assertEquals(Set.of(persistentDriver), persistentTeam.get().getDrivers());
    }

    @Test
    void cannotSaveDriverWithoutTeam() {
        var driver = aDriver();
        driver.setTeam(null);

        assertThrows(PersistenceException.class, () -> {
            driverRepository.create(driver);
            flushAndClearSession(); // exception only happens when insert is cone
        });
    }

    @Test
    void cannotSaveDriverWithNonePersistentTeam() {
        var driver = aDriver();
        driver.setTeam(aTeam()); // team is not persistent

        assertThrows(IllegalStateException.class, () -> {
            driverRepository.create(driver);
            flushAndClearSession(); // exception only happens when insert is cone
        });
    }

    @Test
    void findADriver() {
        var driver = driverRepository.create(() -> {
            var tempDriver = aDriver();
            tempDriver.setTeam(teamRepository.create(aTeam()));
            return tempDriver;
        });
        flushAndClearSession();

        var found = driverRepository.findById(driver.getId());

        assertTrue(found.isPresent());
        assertEquals(driver, found.get());
    }
}

package de.comsystoreply.spring.core.bootcamp.health.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static de.comsystoreply.spring.core.bootcamp.health.HealthStatus.DOWN;
import static de.comsystoreply.spring.core.bootcamp.health.HealthStatus.UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DbHealthCheckTest {

    private final HealthCheckDummyRepository repository = mock(HealthCheckDummyRepository.class);
    private DbHealthCheck healthCheck = new DbHealthCheck(repository);

    @Test
    @DisplayName("The check is named 'db-health'")
    void nameIsCorrect() {
        assertEquals("db-health", healthCheck.name());
    }

    @Test
    @DisplayName("The db is considered down if a 'PersistenceException' is thrown when saving an entity to the db is tried")
    void downWhenSaveFailsWithPersistenceException() {
        when(repository.save(any(HealthCheckDummy.class)))
                .thenThrow(new PersistenceException());

        var result = healthCheck.perform();

        assertEquals(DOWN, result.getStatus());
        assertEquals(PersistenceException.class.getCanonicalName(), result.getDetails().get("exception"));
    }

    @Test
    @DisplayName("The db is considered down if a 'PersistenceException' is thrown when loading from the db")
    void downWhenLoadingFailsWithPersistenceException() {
        when(repository.save(any(HealthCheckDummy.class)))
                .thenReturn(new HealthCheckDummy());
        when(repository.findAll())
                .thenThrow(new PersistenceException());

        var result = healthCheck.perform();

        assertEquals(DOWN, result.getStatus());
        assertEquals(PersistenceException.class.getCanonicalName(), result.getDetails().get("exception"));
    }

    @Test
    @DisplayName("The db is considered up if an entity can be saved and is subsequently returned")
    void upWhenEntityCanBeSavedAndThenLoaded() {
        var dummy = mock(HealthCheckDummy.class);

        when(repository.save(any(HealthCheckDummy.class)))
                .thenReturn(dummy);
        when(repository.findAll())
                .thenReturn(List.of(dummy));

        var result = healthCheck.perform();

        assertEquals(UP, result.getStatus());
    }

    @Test
    @DisplayName("The db is considered down if the entity can be saved but is then not subsequently returned")
    void downWhenSavedEntityIsNotReturned() {
        var dummy = mock(HealthCheckDummy.class);
        when(dummy.getId())
                .thenReturn(314358948L);

        when(repository.save(any(HealthCheckDummy.class)))
                .thenReturn(dummy);
        when(repository.findAll())
                .thenReturn(List.of(new HealthCheckDummy()));

        var result = healthCheck.perform();

        assertEquals(DOWN, result.getStatus());
    }
}
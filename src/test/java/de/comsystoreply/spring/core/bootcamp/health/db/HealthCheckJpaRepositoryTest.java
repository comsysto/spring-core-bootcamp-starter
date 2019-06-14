package de.comsystoreply.spring.core.bootcamp.health.db;

import de.comsystoreply.spring.core.bootcamp.config.TestDatabaseConfig;
import de.comsystoreply.spring.core.bootcamp.config.WebConfig;
import de.comsystoreply.spring.core.bootcamp.health.HealthConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitWebConfig({
        HealthConfig.class,
        WebConfig.class,
        TestDatabaseConfig.class
})
@Transactional
class HealthCheckJpaRepositoryTest {

    @Autowired
    private HealthCheckDummyRepository repository;

    @Test
    @DisplayName("ensure no unexpected data is in the table")
    void dbIsEmpty() {
        var allEntities = repository.findAll();

        assertTrue(allEntities.isEmpty());
    }

    @Test
    @DisplayName("entities can be saved to the database")
    void saveAnEntity() {
        var entity = new HealthCheckDummy();

        var savedEntity = repository.save(entity);

        assertNotNull(savedEntity);
        assertNotNull(savedEntity.getId());
    }

    @Test
    @DisplayName("entities that where saved can be loaded from the database")
    void findEntityById() {
        var savedEntity = repository.save(new HealthCheckDummy());

        var loadedEntity = repository.findById(savedEntity.getId());

        assertEquals(savedEntity, loadedEntity);
    }
}

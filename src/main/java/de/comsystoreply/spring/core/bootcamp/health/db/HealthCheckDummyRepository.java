package de.comsystoreply.spring.core.bootcamp.health.db;

import java.util.List;

/**
 * Repository to access {@link HealthCheckDummy} instances.
 */
public interface HealthCheckDummyRepository {

    /**
     * Return all {@code HealthCheckDummy} instances.
     */
    List<HealthCheckDummy> findAll();

    /**
     * Return one {@code HealthCheckDummy} instance identified by its {@code id}.
     */
    HealthCheckDummy findById(long id);

    /**
     * Saves the given {@code HealthCheckDummy} instance. This can be used to create new instances or to update the
     * state of an existing instance.
     */
    HealthCheckDummy save(HealthCheckDummy dummy);
}

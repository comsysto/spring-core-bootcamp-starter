package de.comsystoreply.spring.core.bootcamp.health.db;

import de.comsystoreply.spring.core.bootcamp.health.HealthCheck;
import de.comsystoreply.spring.core.bootcamp.health.HealthCheckResult;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

import static de.comsystoreply.spring.core.bootcamp.health.HealthStatus.DOWN;
import static de.comsystoreply.spring.core.bootcamp.health.HealthStatus.UP;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

/**
 * Performs a {@code HealthCheck} against the database.
 */
public class DbHealthCheck implements HealthCheck {

    private final HealthCheckDummyRepository repository;

    public DbHealthCheck(HealthCheckDummyRepository repository) {
        requireNonNull(repository);

        this.repository = repository;
    }

    @Override
    public String name() {
        return "db-health";
    }

    @Override
    @Transactional
    public HealthCheckResult perform() {
        try {
            var dummy = new HealthCheckDummy();
            var savedDummy = repository.save(dummy);
            var allEntities = repository.findAll();
            repository.delete(savedDummy.getId());

            if (allEntities.contains(savedDummy)) {
                return HealthCheckResult.builder()
                        .status(UP)
                        .build();
            } else {
                return HealthCheckResult.builder()
                        .status(DOWN)
                        .setDetail("error", "could not interact with db")
                        .build();
            }

        } catch (IllegalStateException | IllegalArgumentException | PersistenceException exception) {
            return HealthCheckResult.builder()
                    .status(DOWN)
                    .setDetail("error", "could not interact with db")
                    .setDetail("exception", exception.getClass().getCanonicalName())
                    .setDetail("stacktrace", asList(exception.getStackTrace()).toString())
                    .build();
        }
    }
}

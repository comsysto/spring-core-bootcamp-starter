package de.comsystoreply.spring.core.bootcamp.health;

import de.comsystoreply.spring.core.bootcamp.health.db.DbHealthCheck;
import de.comsystoreply.spring.core.bootcamp.health.db.HealthCheckDummyRepository;
import de.comsystoreply.spring.core.bootcamp.health.db.HealthCheckJpaDummyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration of Spring Beans that are part of the health endpoint.
 */
@Configuration
public class HealthConfig {

    /**
     * Repository used by the database health check.
     */
    @Bean
    public HealthCheckDummyRepository healthCheckRepository() {
        return new HealthCheckJpaDummyRepository();
    }

    /**
     * Health check for the database.
     */
    @Bean
    public HealthCheck dbHealthCheck(HealthCheckDummyRepository repository) {
        return new DbHealthCheck(repository);
    }

    /**
     * Controller that is providing the '/health' endpoint.
     */
    @Bean
    public HealthController healthController(
            /*
             * By injecting a List of HealthCheck we get all Beans in the Spring Context that implement that interface.
             * This allows for some plug-in mechanism when adding further health checks.
             */
            List<HealthCheck> healthChecks
    ) {
        return new HealthController(healthChecks);
    }
}

package de.comsystoreply.spring.core.bootcamp.health;

import de.comsystoreply.spring.core.bootcamp.health.db.HealthCheckDummyRepository;
import de.comsystoreply.spring.core.bootcamp.health.db.HealthCheckJpaDummyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfig {

    @Bean
    public HealthController healthController() {
        return new HealthController();
    }

    @Bean
    public HealthCheckDummyRepository healthCheckRepository() {
        return new HealthCheckJpaDummyRepository();
    }
}

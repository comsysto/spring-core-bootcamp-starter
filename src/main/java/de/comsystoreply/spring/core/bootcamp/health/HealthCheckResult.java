package de.comsystoreply.spring.core.bootcamp.health;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Result of a {@link HealthCheck}.
 */
@JsonSerialize
public interface HealthCheckResult {

    static HealthCheckResultBuilder builder() {
        return new HealthCheckResultBuilder();
    }

    HealthStatus getStatus();

    @JsonInclude(NON_EMPTY)
    Map<String, String> getDetails();
}

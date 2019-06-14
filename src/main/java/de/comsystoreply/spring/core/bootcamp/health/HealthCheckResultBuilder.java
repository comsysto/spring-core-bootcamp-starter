package de.comsystoreply.spring.core.bootcamp.health;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class HealthCheckResultBuilder {

    private HealthStatus status = HealthStatus.DOWN;
    private Map<String, String> details = new HashMap<>();

    HealthCheckResultBuilder() {
    }

    /**
     * Set the status of the {@link HealthCheckResult}. Defaults to {@link HealthStatus#DOWN}.
     *
     * @see HealthCheckResult#getStatus()
     */
    public HealthCheckResultBuilder status(HealthStatus status) {
        requireNonNull(status, "getStatus null is not allowed");

        this.status = status;

        return this;
    }

    /**
     * Set a detail about the {@link HealthCheckResult}. By default the result does not contain any details.
     *
     * @see HealthCheckResult#getDetails()
     */
    public HealthCheckResultBuilder setDetail(String key, String value) {
        requireNonNull(key, "null keys are not allowed for getDetails");

        details.put(key, value);

        return this;
    }

    public HealthCheckResult build() {
        return new ImmutableHealthCheckResult(this.status, this.details);
    }

    @JsonSerialize(as = HealthCheckResult.class)
    public final class ImmutableHealthCheckResult implements HealthCheckResult {

        private final HealthStatus status;

        private final Map<String, String> details;

        private ImmutableHealthCheckResult(
                HealthStatus status,
                Map<String, String> details
        ) {
            this.status = status;
            this.details = Map.copyOf(details);
        }

        @Override
        public HealthStatus getStatus() {
            return status;
        }

        @Override
        public Map<String, String> getDetails() {
            return details;
        }
    }
}

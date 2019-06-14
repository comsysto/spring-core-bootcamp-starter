package de.comsystoreply.spring.core.bootcamp.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static de.comsystoreply.spring.core.bootcamp.health.HealthStatus.DOWN;
import static java.util.Map.entry;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Controller providing a very basic health check. At the moment it can only be used to check if the application is
 * handling any requests at all.
 */
@RestController
@RequestMapping(value = "/health", produces = APPLICATION_JSON_UTF8_VALUE)
class HealthController {

    private final List<HealthCheck> healthChecks;

    HealthController(List<HealthCheck> healthChecks) {
        requireNonNull(healthChecks);

        this.healthChecks = healthChecks;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> get() {
        var checkResult = healthChecks.stream()
                .map(check -> entry(check.name(), check.perform()))
                .collect(toMap(Entry::getKey, Entry::getValue));

        var aggregatedStatus = checkResult.values()
                .stream()
                .map(HealthCheckResult::getStatus)
                .reduce((a, b) -> (a == DOWN) ? a : b);

        /*
         * For more control over the generated result it is normally common practice to use dedicated model classes
         * for the returned entity. This was not done here as the response is to simple to justify the overhead of an
         * dedicated class.
         */
        return ResponseEntity.ok(
                Map.ofEntries(
                        entry("status", aggregatedStatus),
                        entry("details", checkResult)
                )
        );
    }
}

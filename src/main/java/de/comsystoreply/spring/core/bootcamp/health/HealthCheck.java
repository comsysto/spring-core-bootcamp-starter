package de.comsystoreply.spring.core.bootcamp.health;

/**
 * Checks if a part of the application is working correctly. What is checked exactly is depended on the individual
 * implementation. All checks work together to form a picture of the current state of the application as a whole.
 */
public interface HealthCheck {

    /**
     * An unique name for the health check.
     */
    String name();

    /**
     * Performs the health check.
     */
    HealthCheckResult perform();
}

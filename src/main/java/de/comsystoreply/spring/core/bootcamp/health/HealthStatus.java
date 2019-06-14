package de.comsystoreply.spring.core.bootcamp.health;

/**
 * Indication of the health getStatus of a component or the whole application.
 */
public enum HealthStatus {

    /**
     * Working as intended.
     */
    UP,

    /**
     * Application or component currently not working as intended.
     */
    DOWN
}

package de.comsystoreply.spring.core.bootcamp.health.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * DB entity used for DB health checks.
 */
@Entity
@Table(name = "HEALTH_CHECK")
public class HealthCheckDummy {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "HEALTH_CHECK_PK_SEQ")
    private Long id;

    public Long getId() {
        return id;
    }
}

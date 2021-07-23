package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceConfig.class)
@Transactional
abstract class PersistenceIntegrationTest {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Flushes and clears the current JPA session.
     * <p>
     * This is required that DB changes still cached in the session are executed and the session cache is cleared. If
     * this is not done tests might not work as expected. If the session state is not written to the DB before the test
     * ends the corresponding SQL might never be executed. If the cache is not cleared, an outdated state of entities
     * might be returned.
     * <p>
     * In production code this should rarely if ever be done.
     */
    protected void flushAndClearSession() {
        entityManager.flush();
        entityManager.clear();
    }
}

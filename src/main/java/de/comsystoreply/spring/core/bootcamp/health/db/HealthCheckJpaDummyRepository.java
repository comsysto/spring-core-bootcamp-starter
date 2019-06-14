package de.comsystoreply.spring.core.bootcamp.health.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * JPA based implementation of {@code HealthCheckDummyRepository}.
 */
@Repository
@Transactional(readOnly = true)
public class HealthCheckJpaDummyRepository implements HealthCheckDummyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HealthCheckDummy> findAll() {
        var query = entityManager.createQuery("FROM HealthCheckDummy", HealthCheckDummy.class);

        return query.getResultList();
    }

    @Override
    public HealthCheckDummy findById(long id) {
        return entityManager.find(HealthCheckDummy.class, id);
    }

    @Override
    @Transactional(readOnly = false)
    public HealthCheckDummy save(HealthCheckDummy dummy) {
        return entityManager.merge(dummy);
    }

    @Override
    public void delete(long id) {
        var entity = findById(id);

        entityManager.remove(entity);
    }
}

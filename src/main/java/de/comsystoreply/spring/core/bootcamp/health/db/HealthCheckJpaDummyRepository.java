package de.comsystoreply.spring.core.bootcamp.health.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * JPA based implementation of {@code HealthCheckDummyRepository}.
 */
@Repository
@Transactional(propagation = REQUIRED, readOnly = true)
public class HealthCheckJpaDummyRepository implements HealthCheckDummyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HealthCheckDummy> findAll() {
        var criteriaQuery = entityManager.getCriteriaBuilder()
                .createQuery(HealthCheckDummy.class);
        var root = criteriaQuery.from(HealthCheckDummy.class);
        var selectAll = criteriaQuery.select(root);

        var query = entityManager.createQuery(selectAll);

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
}

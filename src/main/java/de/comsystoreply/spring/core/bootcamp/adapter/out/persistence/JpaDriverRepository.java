package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Repository
@Scope(proxyMode = TARGET_CLASS)
class JpaDriverRepository extends JpaCrudRepositroy<Driver, Long> implements DriverRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JpaDriverRepository() {
        super(Driver.class);
    }

    @Override
    public List<Driver> findAll() {
        return entityManager.createQuery("SELECT d FROM Driver d", Driver.class)
                .getResultList();
    }
}

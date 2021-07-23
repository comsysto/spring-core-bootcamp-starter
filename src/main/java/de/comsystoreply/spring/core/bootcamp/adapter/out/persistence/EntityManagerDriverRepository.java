package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;

@Repository
class EntityManagerDriverRepository extends AbstractCrudRepositroy<Driver, Long> implements DriverRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EntityManagerDriverRepository() {
        super(Driver.class);
    }

    @Override
    public List<Driver> findAll() {
        return entityManager.createQuery("SELECT d FROM Driver d", Driver.class)
                .getResultList();
    }
}

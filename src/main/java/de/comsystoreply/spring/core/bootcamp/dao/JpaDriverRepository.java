package de.comsystoreply.spring.core.bootcamp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaDriverRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Driver> findAll() {
        return entityManager.createQuery("SELECT d FROM Driver d", Driver.class).getResultList();
    }

    @Transactional
    public void create(Driver driver) {
        entityManager.persist(driver);
    }
}

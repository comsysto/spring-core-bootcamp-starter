package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class JpaCrudRepositroy<T, ID> implements CrudRepository<T, ID> {

    private final Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    JpaCrudRepositroy(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T create(T item) {
        return entityManager.merge(item);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                entityManager.find(clazz, id)
        );
    }

    @Override
    public void delete(T item) {
        entityManager.remove(item);
    }
}

package de.comsystoreply.spring.core.bootcamp.adapter.database;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public interface CrudRepository<T, ID> {

    @Transactional
    T create(T item);

    @Transactional(readOnly = true)
    Optional<T> findById(ID id);

    @Transactional
    void delete(T item);
}

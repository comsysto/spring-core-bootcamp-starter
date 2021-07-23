package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for repositories fetching entities from the database.
 *
 * @param <T>  the type of entity
 * @param <ID> the type of the entity's ID
 */
public interface CrudRepository<T, ID> {

    @Transactional
    T create(T item);

    default T create(Supplier<T> supplier) {
        return create(supplier.get());
    }

    @Transactional(readOnly = true)
    Optional<T> findById(ID id);

    @Transactional(readOnly = true)
    List<T> findAll();

    @Transactional
    void delete(T item);
}
package de.comsystoreply.spring.core.bootcamp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarEntityRepository extends CrudRepository<CarEntity, Long> {

    @Override
    List<CarEntity> findAll();
}

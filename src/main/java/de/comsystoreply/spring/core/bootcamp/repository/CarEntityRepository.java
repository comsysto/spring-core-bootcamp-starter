package de.comsystoreply.spring.core.bootcamp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntityRepository extends CrudRepository<CarEntity, Long> {

}

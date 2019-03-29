package de.comsystoreply.spring.core.bootcamp.repositories;

import de.comsystoreply.spring.core.bootcamp.repositories.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}

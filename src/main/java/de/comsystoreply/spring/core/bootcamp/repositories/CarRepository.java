package de.comsystoreply.spring.core.bootcamp.repositories;

import de.comsystoreply.spring.core.bootcamp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

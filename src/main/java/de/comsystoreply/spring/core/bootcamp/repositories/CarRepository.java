package de.comsystoreply.spring.core.bootcamp.repositories;

import de.comsystoreply.spring.core.bootcamp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

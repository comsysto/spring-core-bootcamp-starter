package de.comsystoreply.spring.core.bootcamp.repo;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Override
    List<Driver> findAll();


    List<Driver> findByFirstNameAndLastNameAndAge(String firstName, String lastName,int age);

    // CriteriaAPI für kompliziertere Queries (SQL-like)

}

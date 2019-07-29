package de.comsystoreply.spring.core.bootcamp.repo;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver,Long> {

    @Override
    List<Driver> findAll();


}

package de.comsystoreply.springtrainingdemo.repos;

import de.comsystoreply.springtrainingdemo.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {

}

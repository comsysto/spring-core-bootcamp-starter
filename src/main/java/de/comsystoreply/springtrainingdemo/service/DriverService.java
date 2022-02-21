package de.comsystoreply.springtrainingdemo.service;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(String firstName) {
        return new Driver(firstName);
    }

    public Driver saveDriver(Driver driver) throws ResponseStatusException {
        this.driverRepository.save(driver);
        Optional<Driver> optionalDriver = this.driverRepository.findById(driver.getId());

        if (optionalDriver.isPresent()) {
            return optionalDriver.get();
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Iterable<Driver> getAll(){
        return driverRepository.findAll();
    }


}

package de.comsystoreply.springtrainingdemo.service;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(String firstName) {
        return new Driver(firstName);
    }

    @Transactional
    public Driver saveDriver(Driver driver) {
        return this.driverRepository.save(driver);
    }

    public Iterable<Driver> getAll(){
        return driverRepository.findAll();
    }


}

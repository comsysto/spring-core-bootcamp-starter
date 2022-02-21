package de.comsystoreply.springtrainingdemo.service;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;

public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(String firstName) {
        return new Driver(firstName);
    }

    public void saveDriver(Driver driver) {
        this.driverRepository.save(driver);
    }


}

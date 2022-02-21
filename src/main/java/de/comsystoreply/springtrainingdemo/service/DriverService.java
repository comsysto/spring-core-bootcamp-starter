package de.comsystoreply.springtrainingdemo.service;

import de.comsystoreply.springtrainingdemo.model.Driver;

public class DriverService {

    public Driver createDriver(String firstName) {
        return new Driver(firstName);
    }

    public void saveDriver(Driver driver) {
        
    }

}

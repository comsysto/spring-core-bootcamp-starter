package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.dao.Driver;
import de.comsystoreply.spring.core.bootcamp.dao.JpaDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {
    private JpaDriverRepository driverRepository;

    @Autowired
    public DriverController(JpaDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

}

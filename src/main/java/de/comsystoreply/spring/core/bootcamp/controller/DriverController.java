package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.dao.Driver;
import de.comsystoreply.spring.core.bootcamp.dao.SpringDataDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class DriverController {
    private SpringDataDriverRepository driverRepository;

    @Autowired
    public DriverController(SpringDataDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Driver> getAllDrivers() {
        try {
            return driverRepository.findAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @PostMapping(value = "/drivers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createDriver(@RequestBody Driver driver) {
        try {
            Driver saved = driverRepository.save(driver);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }
}

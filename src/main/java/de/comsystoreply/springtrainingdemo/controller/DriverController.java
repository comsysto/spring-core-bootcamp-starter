package de.comsystoreply.springtrainingdemo.controller;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public Iterable<Driver> getDrivers() {
        return driverService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver) {
        try {
            return driverService.saveDriver(driver);
        } catch (Exception e) {
            throw new DriverNotFoundException();    // todo evtl ControllerAdvice
        }
    }


}

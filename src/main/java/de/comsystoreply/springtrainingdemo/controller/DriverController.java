package de.comsystoreply.springtrainingdemo.controller;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(value ="/drivers", produces = MediaType.APPLICATION_XML_VALUE)
    public Iterable<Driver> getDrivers() {
        return driverService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/drivers", produces = MediaType.APPLICATION_XML_VALUE)
    public Driver createDriver(@RequestBody Driver driver) {
        try {
            return driverService.saveDriver(driver);
        } catch (Exception e) {
            throw new DriverNotFoundException();    // todo evtl ControllerAdvice
        }
    }


}

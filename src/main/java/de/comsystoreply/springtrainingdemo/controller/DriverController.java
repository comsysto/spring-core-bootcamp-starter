package de.comsystoreply.springtrainingdemo.controller;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public Iterable<Driver> getDrivers(){
        return driverService.getAll();
    }


}

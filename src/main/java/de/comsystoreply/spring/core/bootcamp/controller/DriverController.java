package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/driver", produces = APPLICATION_JSON_UTF8_VALUE)
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<Driver> get(@PathVariable long id) {
        Driver driver = driverService.findById(id);
        return ResponseEntity.ok(driver);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> list() {
        List<Driver> allList = driverService.findAll();
        return ResponseEntity.ok(allList);
    }

    @PostMapping
    public ResponseEntity<Driver> save(@RequestBody Driver driver) {
        Driver savedDriver = driverService.save(driver);
        return ResponseEntity.ok(savedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {
        driverService.delete(id);
        return ResponseEntity.ok(id);
    }
}
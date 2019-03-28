package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.repositories.model.CarDto;
import de.comsystoreply.spring.core.bootcamp.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> listAll() {
        return this.carService.findAll();
    }

    @PostMapping("/create")
    public CarDto create(@RequestBody CarDto carDto) {

        return carDto;
    }

}

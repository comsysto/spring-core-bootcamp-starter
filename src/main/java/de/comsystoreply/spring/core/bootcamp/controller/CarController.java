package de.comsystoreply.spring.core.bootcamp.controller;

import java.util.List;

import de.comsystoreply.spring.core.bootcamp.car.Car;
import de.comsystoreply.spring.core.bootcamp.car.CarService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_VALUE)
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){

        return carService.getCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
}

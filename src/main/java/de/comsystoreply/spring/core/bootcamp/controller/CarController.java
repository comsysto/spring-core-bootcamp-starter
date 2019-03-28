package de.comsystoreply.spring.core.bootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @GetMapping("/cars")
    public List<Car> listAll(){
        return List.of((new Car(1L, "Ferrari")));
    }
}

package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarService {

    private CarRepository repository;

    @Autowired
    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public List<Car> findAllCars() {
        return repository.findAllCars();
    }
}

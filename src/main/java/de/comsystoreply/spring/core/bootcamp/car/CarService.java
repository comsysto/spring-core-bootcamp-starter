package de.comsystoreply.spring.core.bootcamp.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    private CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getCars() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(Car::new)
                .toList();
    }

    public Car createCar(Car car) {
        CarEntity carEntity = repository.save(new CarEntity(car));
        return new Car(carEntity);
    }
}

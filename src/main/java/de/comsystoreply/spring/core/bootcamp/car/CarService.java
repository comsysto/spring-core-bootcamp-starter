package de.comsystoreply.spring.core.bootcamp.car;

import java.util.List;
import java.util.stream.StreamSupport;

import de.comsystoreply.spring.core.bootcamp.repository.CarEntity;
import de.comsystoreply.spring.core.bootcamp.repository.CarEntityRepository;
import de.comsystoreply.spring.core.bootcamp.repository.CarRepository;
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
        return repository.findAll();
    }

    public Car createCar(Car car) {
        return repository.save(car);
    }
}

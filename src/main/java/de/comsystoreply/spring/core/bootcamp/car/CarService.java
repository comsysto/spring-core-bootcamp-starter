package de.comsystoreply.spring.core.bootcamp.car;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Car createCar(Car car) {

        this.cars.add(car);
        LOGGER.debug("{}",cars.size());
        return car;
    }
}

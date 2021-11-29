package de.comsystoreply.spring.core.bootcamp.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Car createCar(Car car) {
        cars.add(car);
        return null;
    }

    public List<Car> createCars(List<Car> cars) {

        return null;
    }

}

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

    public void createCar(Car car) {
        cars.add(car);
    }

    public void createCars(List<Car> cars) {
        cars.addAll(cars);
    }

}

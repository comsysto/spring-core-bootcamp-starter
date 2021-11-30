package de.comsystoreply.spring.core.bootcamp.repository;

import de.comsystoreply.spring.core.bootcamp.car.Car;

import java.util.List;

public interface CarRepository {
    public Car save(Car car);
    public List<Car> findAll();
}

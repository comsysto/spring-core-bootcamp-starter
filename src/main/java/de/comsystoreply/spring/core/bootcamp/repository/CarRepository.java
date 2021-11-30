package de.comsystoreply.spring.core.bootcamp.repository;

import de.comsystoreply.spring.core.bootcamp.car.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class CarRepository {

    private CarEntityRepository carEntityRepository;

    public CarRepository(CarEntityRepository carEntityRepository) {
        this.carEntityRepository = carEntityRepository;
    }

    public Car save(Car car) {
        return entityToCar(carEntityRepository.save(carToEntity(car)));
    }

    private Car entityToCar(CarEntity entity) {
        Car car = new Car();
        car.setId(entity.getId());
        car.setTitle(entity.getTitle());
        car.setHorsePower(entity.getHorsePower());
        car.setWeightInKilo(entity.getWeightInKilo());
        return car;
    }

    private CarEntity carToEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setId(car.getId());
        entity.setTitle(car.getTitle());
        entity.setHorsePower(car.getHorsePower());
        entity.setWeightInKilo(car.getWeightInKilo());
        return entity;
    }

    public List<Car> findAll() {
        return StreamSupport.stream(carEntityRepository.findAll().spliterator(), false)
                .map(this::entityToCar)
                .toList();
    }
}

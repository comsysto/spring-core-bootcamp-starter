package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.repository.CarRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @x
    private CarRepository carRepository;
    @MockI
    private final CarService carService = new CarService(carRepository);

    @Test
    void getCars() {
    }

    @Test
    void createCar() {
    }
}
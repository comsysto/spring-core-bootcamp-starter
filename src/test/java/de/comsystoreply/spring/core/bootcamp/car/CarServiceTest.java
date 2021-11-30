package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    void getCars() {
      var expectedCars = List.of(new Car());
      when(carRepository.findAll()).thenReturn(expectedCars);

      var actualCars = carService.getCars();

      assertSame(expectedCars, actualCars);
    }

    @Test
    void createCar() {
      var expectedCar = new Car();
      var suppliedCar = new Car();
      when(carRepository.save(Mockito.any())).thenReturn(expectedCar);

      var actualCar = carService.createCar(suppliedCar);

      assertSame(expectedCar, actualCar);
      verify(carRepository).save(suppliedCar);
    }
}
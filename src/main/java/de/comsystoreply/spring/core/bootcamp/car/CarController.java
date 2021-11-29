package de.comsystoreply.spring.core.bootcamp.car;

import java.awt.print.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_VALUE)
public class CarController {

    @Autowired 
    private CarService carService;

    @GetMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
}

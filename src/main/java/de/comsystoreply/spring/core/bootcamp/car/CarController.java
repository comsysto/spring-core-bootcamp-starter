package de.comsystoreply.spring.core.bootcamp.car;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/cars", produces = APPLICATION_JSON_VALUE)
public class CarController {

    @GetMapping
    public List<Car> getCars(){
        return List.of(new Car(), new Car(), new Car(), new Car());
    }
}

package de.comsystoreply.spring.core.bootcamp.car;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    public List<Car> getCars() {
        return List.of(new Car(), new Car(), new Car(), new Car());
    }
}

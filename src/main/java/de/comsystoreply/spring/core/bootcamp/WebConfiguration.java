package de.comsystoreply.spring.core.bootcamp;

import de.comsystoreply.spring.core.bootcamp.controller.CarController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    private CarController carController;
}

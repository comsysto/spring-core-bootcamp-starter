package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.ApplicationInitializer;
import de.comsystoreply.spring.core.bootcamp.repositories.CarRepository;
import de.comsystoreply.spring.core.bootcamp.repositories.RepositoryConfiguration;
import de.comsystoreply.spring.core.bootcamp.services.ServicesConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {WebConfiguration.class,
                ServicesConfiguration.class}
)
@Configuration
class CarControllerTest {
    @Autowired
    private CarController carController;

    @Bean
    public CarRepository carRepository(){
        return null;
    }

    @Test
    void hasAutowired() {
        Assertions.assertNotNull(carController);
    }
}
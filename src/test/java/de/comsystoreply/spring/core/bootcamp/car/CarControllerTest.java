package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.controller.CarController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigWebContextLoader.class,
        classes = {CarControllerTest.Configuration.class})
public class CarControllerTest {
    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mvc;
    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @org.springframework.context.annotation.Configuration
    static class Configuration{
        @Bean
        public CarController carController(){
            return null
        }
    }

}
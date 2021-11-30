package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.controller.CarController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigWebContextLoader.class,
        classes = {CarControllerTest.Configuration.class})
public class CarControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    //note: Spring Boot offers "MockBean"
    @Autowired
    private CarService carService;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    void getCars() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/cars").accept("todo")).andExpect(status().isOk());
    }

    @org.springframework.context.annotation.Configuration
    static class Configuration{
        @Bean
        public CarController carController(CarService carService) {
            return new CarController(carService);
        }

        @Bean
        public CarService carService() {
            return Mockito.mock(CarService.class);
        }
    }

}
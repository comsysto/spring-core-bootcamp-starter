package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.controller.CarController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        var expectedCars = List.of(new Car(12L, "Our first test", 700, 780.0f));
        when(carService.getCars()).thenReturn(expectedCars);

        this.mvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 12,\n" +
                        "    \"title\": \"Our first test\",\n" +
                        "    \"horsePower\": 700,\n" +
                        "    \"weightInKilo\": 780.0\n" +
                        "  }\n" +
                        "]"));
    }

    // Be very careful with @Configuration annotations in tests as they might be picket up by other test classes
    @EnableWebMvc
    static class Configuration {
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
package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.repositories.CarRepository;
import de.comsystoreply.spring.core.bootcamp.repositories.model.CarDto;
import de.comsystoreply.spring.core.bootcamp.repositories.model.CarEntity;
import de.comsystoreply.spring.core.bootcamp.services.ServicesConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {WebConfiguration.class,
                ServicesConfiguration.class}
)
@Configuration
class CarControllerTest {

    @Autowired
    private CarController carController;

    @Autowired
    private CarRepository carRepository;

    private MockMvc mock = standaloneSetup(CarController.class).build();

    @Bean
    public CarRepository carRepository() {
        return Mockito.mock(CarRepository.class);
    }

    @Test
    void hasAutowired() {
        Assertions.assertNotNull(carController);
    }

    @Test
    void testListAll() {
        Mockito.when(carRepository.findAll()).thenReturn(List.of(new CarEntity(123L, "Testname")));
        //List<CarDto> carDtos = carController.listAll();
        mock.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.status", equalTo("up")));
    }
}
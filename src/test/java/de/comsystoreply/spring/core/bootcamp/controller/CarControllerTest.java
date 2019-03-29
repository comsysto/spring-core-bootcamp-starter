package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.repositories.CarRepository;
import de.comsystoreply.spring.core.bootcamp.repositories.RepositoryConfiguration;
import de.comsystoreply.spring.core.bootcamp.repositories.model.CarDto;
import de.comsystoreply.spring.core.bootcamp.repositories.model.CarEntity;
import de.comsystoreply.spring.core.bootcamp.services.ServicesConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.PrintingResultHandler;

import java.io.PrintWriter;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {WebConfiguration.class,
                ServicesConfiguration.class,
                RepositoryConfiguration.class}
)
@Configuration
@ActiveProfiles("test")
class CarControllerTest {

    @Autowired
    private CarController carController;

    @Autowired
    private CarRepository carRepository;

    private MockMvc mock ;


    @BeforeEach
    public void init(){
        this.mock =standaloneSetup(carController).build();
        carRepository.save(new CarEntity(123L, "Testname"));
    }

    @AfterEach
    public void clear(){
        carRepository.deleteById(123L);
    }

    @Test
    void hasAutowired() {
        Assertions.assertNotNull(carController);
    }

    @Test
    void testListAll() throws Exception {
        mock.perform(get("/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
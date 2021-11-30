package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.Application;
import org.apache.catalina.LifecycleException;
import org.apache.coyote.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.RequestEntity.get;
import static org.springframework.http.RequestEntity.post;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class E2eTest {

    public static final String TITLE = "Batmobile";
    public static final int HORSE_POWER = 500;
    public static final int WEIGHT_IN_KILO = 5000;
    private static Application application;

    private final RestTemplate restTemplate = new RestTemplate();


    @BeforeAll
    static void beforeAll() throws LifecycleException, IOException {
        System.setProperty("spring.profiles.active", "h2");
        application = new Application();
        application.start();
    }

    @AfterAll
    void tearDown() throws LifecycleException {
        application.stop();
    }

    @Test
    @Order(1)
    void createCar() {
        var suppliedCar = new Car();
        suppliedCar.setTitle(TITLE);
        suppliedCar.setHorsePower(HORSE_POWER);
        suppliedCar.setWeightInKilo(WEIGHT_IN_KILO);


        ResponseEntity<Car> response = restTemplate.exchange(
                post("http://localhost:8090/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(suppliedCar),
                Car.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Car returnedCar = response.getBody();
        assertCarProperties(returnedCar);
        assertNotNull(returnedCar.getId());
    }

    @Test
    @Order(2)
    void getCars() {
        ResponseEntity<List<Car>> response = restTemplate.exchange(
                get("http://localhost:8090/cars").build(),
                new ParameterizedTypeReference<>() {
                });
        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Car> cars = response.getBody();
        assertNotNull(cars);
        assertEquals(cars.size(), 1);

        Car firstCar = cars.get(0);
        assertCarProperties(firstCar);
        assertNotNull(firstCar.getId());
    }

    private void assertCarProperties(Car createdCar) {
        assertNotNull(createdCar);
        assertEquals(TITLE, createdCar.getTitle());
        assertEquals(HORSE_POWER, createdCar.getHorsePower());
        assertEquals(WEIGHT_IN_KILO, createdCar.getWeightInKilo());
    }

}
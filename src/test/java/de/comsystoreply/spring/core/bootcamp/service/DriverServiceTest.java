package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.ApplicationInitializer;
import de.comsystoreply.spring.core.bootcamp.config.PersistenceConfiguration;
import de.comsystoreply.spring.core.bootcamp.config.ServiceConfiguration;
import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.repo.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {ServiceConfiguration.class, PersistenceConfiguration.class})

class DriverServiceTest {

    @Autowired DriverService driverService;
    @Autowired DriverRepository driverRepository;

    Driver initialDriver;

    @BeforeEach
    void setup() {
        initialDriver = new Driver();
        initialDriver.setId(1);
        initialDriver.setFirstName("Intial Driver1");
        initialDriver.setLastName("Initial DriverName1");
        initialDriver.setAge(23);
        driverService.save(initialDriver);
    }
    @Test
    void findById() {
        Driver foundDriver = driverService.findById(1);
        assertNotNull(foundDriver);
        assertEquals(initialDriver, foundDriver);
    }

    @Test
    void findByIdNotFound() {
        Driver foundDriver = driverService.findById(9999);
        assertNull(foundDriver);
    }

    @Test
    void findAll() {
        List<Driver> all = driverService.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void save() {
        Driver driver = new Driver();
        driver.setFirstName("Driver1");
        driver.setLastName("DriverName1");
        driver.setAge(23);
        Driver savedDriver = driverService.save(driver);
        assertNotNull(savedDriver.getId());
        assertEquals("Driver1", savedDriver.getFirstName());
        assertEquals("DriverName1", savedDriver.getLastName());
        assertEquals(23, savedDriver.getAge());
    }

    @Test
    void delete() {
       driverService.delete(1);

    }
}
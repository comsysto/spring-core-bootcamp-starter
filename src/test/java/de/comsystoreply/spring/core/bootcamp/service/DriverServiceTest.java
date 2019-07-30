package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.ApplicationInitializer;
import de.comsystoreply.spring.core.bootcamp.config.PersistenceConfiguration;
import de.comsystoreply.spring.core.bootcamp.config.ServiceConfiguration;
import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {ServiceConfiguration.class, PersistenceConfiguration.class})
class DriverServiceTest {
    @Autowired DriverService driverService;

    @Test
    void findById() {
    }

    @Test
    void findAll() {
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
    }
}
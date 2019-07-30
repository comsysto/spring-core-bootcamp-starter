package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.config.PersistenceConfiguration;
import de.comsystoreply.spring.core.bootcamp.config.Profiles;
import de.comsystoreply.spring.core.bootcamp.config.ServiceConfiguration;
import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.repo.DriverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = {ServiceConfiguration.class, PersistenceConfiguration.class})
@Transactional
@ActiveProfiles(Profiles.TEST)
class DriverServiceTest {

    @Autowired
    DriverService driverService;
    @Autowired
    DriverRepository driverRepository;

    @Test
    void findById() {
        Driver initialDriver = createInitialDriver();

        Driver foundDriver = driverService.findById(initialDriver.getId());
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
        Driver initialDriver = createInitialDriver();

        List<Driver> all = driverService.findAll();
        assertEquals(1, all.size());
        assertEquals(initialDriver, all.get(0));
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
        Driver initialDriver = createInitialDriver();

        driverService.delete(initialDriver.getId());

        assertEquals(0, driverService.findAll().size());
    }

    private Driver createInitialDriver() {
        Driver initialDriver = new Driver();
        initialDriver.setFirstName("Initial Driver1");
        initialDriver.setLastName("Initial DriverName1");
        initialDriver.setAge(23);
        return driverService.save(initialDriver);
    }
}
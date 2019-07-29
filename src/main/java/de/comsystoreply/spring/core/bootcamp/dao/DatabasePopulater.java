package de.comsystoreply.spring.core.bootcamp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabasePopulater {
    private SpringDataDriverRepository driverRepository;

    @Autowired
    public DatabasePopulater(SpringDataDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @PostConstruct
    public void populate() {
        Driver driver = new Driver("Lewis", "Hamilton");

        driverRepository.save(driver);
    }
}

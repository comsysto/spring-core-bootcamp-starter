package de.comsystoreply.spring.core.bootcamp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DatabasePopulater {
    private JpaDriverRepository driverRepository;

    @Autowired
    public DatabasePopulater(JpaDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @PostConstruct
    public void populate() {
        Driver driver = new Driver("Lewis", "Hamilton");

        driverRepository.create(driver);
    }
}

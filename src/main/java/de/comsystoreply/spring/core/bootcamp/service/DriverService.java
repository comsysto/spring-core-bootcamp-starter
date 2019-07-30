package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.repo.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepo;

    @Transactional(readOnly = true)
    public Driver findById(long id) {
        Optional<Driver> driver = driverRepo.findById(id);
        return driver.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Driver> findAll() {
        List<Driver> allList = driverRepo.findAll();
        return allList;
    }

    @Transactional
    public Driver save(Driver driver) {
        Driver savedDriver = driverRepo.save(driver);
        return savedDriver;
    }

    @Transactional
    public void delete(long id) {
        driverRepo.deleteById(id);
    }

}

package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.repo.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepo;

    public Driver findById(long id) {
        Optional<Driver> driver = driverRepo.findById(id);
        return driver.orElse(null);
    }

    public List<Driver> findAll() {
        List<Driver> allList = driverRepo.findAll();
        return allList;
    }

    public Driver save(Driver driver) {
        Driver savedDriver = driverRepo.save(driver);
        return savedDriver;
    }

    public void delete(long id) {
        driverRepo.deleteById(id);
    }

}

package de.comsystoreply.springtrainingdemo;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import de.comsystoreply.springtrainingdemo.service.RacingTeamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RacingTeamApplicationTests {

    private DriverRepository driverRepository;

    @BeforeAll
    void setup(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Test
    void createTeam() {
        RacingTeamService racingTeamService = new RacingTeamService();
        Assert.notNull(racingTeamService.createRacingTeam("someRacingTeam"));

    }

    @Test
    void saveDriver() {
        DriverService driverService = new DriverService(driverRepository);
        Driver driver = new Driver("Max");

        driverService.saveDriver(driver);
        Assert.isTrue(driverRepository.findById(driver.getId()).isPresent());

    }


}

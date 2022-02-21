package de.comsystoreply.springtrainingdemo;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import de.comsystoreply.springtrainingdemo.service.RacingTeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RacingTeamApplicationTests {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverService driverService;

    @Test
    void createTeam() {
        RacingTeamService racingTeamService = new RacingTeamService();
        assertThat(racingTeamService.createRacingTeam("someRacingTeam")).isNotNull();
    }

    @Test
    void saveDriver() {
        Driver driver = new Driver("Max");

        this.driverService.saveDriver(driver);
        assertThat(driverRepository.findById(driver.getId()).isPresent()).isTrue();
    }
}

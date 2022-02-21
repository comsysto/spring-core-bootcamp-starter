package de.comsystoreply.springtrainingdemo;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import de.comsystoreply.springtrainingdemo.service.RacingTeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class RacingTeamApplicationTests {

    @Autowired
    private MockMvc mockMvc;
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

    @Test
    void allDrivers() throws Exception {
        List<Driver> drivers = new ArrayList<Driver>();
        drivers.addAll( List.of(new Driver("max"), new Driver("moritz")));

        driverRepository.saveAll(drivers);

        this.mockMvc.perform(get("/drivers")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("max")));



    }
}

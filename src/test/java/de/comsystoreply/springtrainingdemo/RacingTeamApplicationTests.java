package de.comsystoreply.springtrainingdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.comsystoreply.springtrainingdemo.config.DriverConfig;
import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.repos.DriverRepository;
import de.comsystoreply.springtrainingdemo.service.DriverService;
import de.comsystoreply.springtrainingdemo.service.RacingTeamService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class RacingTeamApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverService driverService;
    @Autowired
    private ObjectMapper objectMapper;


    @AfterEach
    void afterEach() {
        driverRepository.deleteAll();
    }

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
        drivers.addAll( List.of(new Driver("Peter"), new Driver("Moritz")));

        driverRepository.saveAll(drivers);

        this.mockMvc.perform(get("/drivers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Peter")))
                .andExpect(content().string(containsString("Moritz")));
    }

    @Test
    void createDriver() throws Exception {

        Driver driver = new Driver("someDriver");
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(driver);

        this.mockMvc.perform(post("/drivers").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("someDriver")));
    }

    @Test
    void testObjectMapper() throws Exception{

        Driver driver = new Driver("someName", new Date());

        String driverConfigString = this.objectMapper.writeValueAsString(driver);
        System.out.println(driverConfigString);

    }

}

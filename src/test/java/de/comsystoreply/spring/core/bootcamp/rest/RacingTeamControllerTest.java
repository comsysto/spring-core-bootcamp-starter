package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.Driver;
import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.persistence.RacingTeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class RacingTeamControllerTest {

    private RacingTeamRepository repository = Mockito.mock(RacingTeamRepository.class);
    private RacingTeamController rtc = new RacingTeamController(repository);
    private MockMvc mock = standaloneSetup(rtc).build();

    @Test
    void getTeams() throws Exception {
        RacingTeam racingTeam = new RacingTeam(6L, "racing-team2", List.of());
        Driver driver = new Driver(1L, "best", "racerX", LocalDate.now(), racingTeam);
        racingTeam.setDrivers(List.of(driver));
        Mockito.when(repository.findAll()).thenReturn(List.of(racingTeam));

        mock.perform(get("/teams").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo(racingTeam.getId().intValue())));
//                .andExpect(jsonPath("$[0].driver[*].id").value().containsInAnyOrder(1));
    }
}

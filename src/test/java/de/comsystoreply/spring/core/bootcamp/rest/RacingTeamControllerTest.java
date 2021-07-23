package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.Driver;
import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.persistence.RacingTeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class RacingTeamControllerTest {

    private RacingTeamRepository repository = Mockito.mock(RacingTeamRepository.class);
    private RacingTeamController rtc = new RacingTeamController(repository);
    private MockMvc mock = standaloneSetup(rtc).build();

    @Test
    void getTeams() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new RacingTeam(5, "racing-team", List.of(new Driver(1, "best", "racerX", LocalDate.now(), ....)))));

        mock.perform(get("/teams").accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

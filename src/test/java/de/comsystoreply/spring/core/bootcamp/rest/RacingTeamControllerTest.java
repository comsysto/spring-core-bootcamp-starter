package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.persistence.RacingTeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class RacingTeamControllerTest {

    private RacingTeamRepository repository = Mockito.mock(RacingTeamRepository.class);
    private RacingTeamController rtc = new RacingTeamController(repository);
    private MockMvc mock = standaloneSetup(RacingTeamController.class).build();

    @Test
    void getTeams() throws Exception {

        mock.perform(get("/teams").accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

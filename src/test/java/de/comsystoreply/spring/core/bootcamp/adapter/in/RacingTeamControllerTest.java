package de.comsystoreply.spring.core.bootcamp.adapter.in;

import java.util.UUID;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.comsystoreply.spring.core.bootcamp.WebMvcIntegrationTest;
import de.comsystoreply.spring.core.bootcamp.application.RacingTeamApi;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RacingTeamControllerTest extends WebMvcIntegrationTest {

    @Autowired
    private RacingTeamApi racingTeamApi;

    @Nested
    class CreateRacingTeam {
        @Test
        void createRacingTeam() throws Exception {
            mock.perform(
                            post("/api/racing-team/")
                                    .content("{\"name\":\"test-team\"}")
                                    .contentType(APPLICATION_JSON)
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isCreated());
        }
    }

    @Nested
    class FindById {
        @Test
        void returnNotFoundIfRandomId() throws Exception {
            var id = Id.randomOf(RacingTeam.class);

            mock.perform(
                            get("/api/racing-team/{id}", id.raw())
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isNotFound());
        }

        @Test
        void returnRacingTeamIfItExists() throws Exception {
            var racingTeam = racingTeamApi.save(
                    racingTeamApi.createNewRacingTeam(UUID.randomUUID().toString())
            );

            mock.perform(
                            get("/api/racing-team/{id}", racingTeam.id().raw())
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(APPLICATION_JSON))
                    .andExpect(jsonPath("$.id", equalTo(racingTeam.id().raw())))
                    .andExpect(jsonPath("$.name", equalTo(racingTeam.name())));
        }
    }
}

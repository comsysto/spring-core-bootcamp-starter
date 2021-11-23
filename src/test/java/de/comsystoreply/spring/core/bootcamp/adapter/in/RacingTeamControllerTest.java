package de.comsystoreply.spring.core.bootcamp.adapter.in;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.comsystoreply.spring.core.bootcamp.WebMvcIntegrationTest;
import de.comsystoreply.spring.core.bootcamp.application.RacingTeamApi;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

import static de.comsystoreply.spring.core.bootcamp.TestData.aDriver;
import static de.comsystoreply.spring.core.bootcamp.TestData.aRacingTeam;
import static org.hamcrest.Matchers.empty;
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
        void returnNotFoundIfTeamDoesNotExist() throws Exception {
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
                    aRacingTeam()
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

    @Nested
    class FindDriverInTeam {
        @Test
        void returnNotFoundIfTeamDoesNotExist() throws Exception {
            var id = Id.randomOf(RacingTeam.class);

            mock.perform(
                            get("/api/racing-team/{id}/drivers", id.raw())
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isNotFound());
        }

        @Test
        void returnEmptyListIfTeamHasNoDriver() throws Exception {
            var team = racingTeamApi.save(
                    aRacingTeam()
            );

            mock.perform(
                            get("/api/racing-team/{id}/drivers", team.id().raw())
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(APPLICATION_JSON))
                    .andExpect(jsonPath("$", empty()));
        }

        @Test
        void returnListOfDriverInTeam() throws Exception {
            var driverA = aDriver()
                    .withName("Speed Racer");
            var driverB = aDriver()
                    .withName("Arthur Dent");

            var team = racingTeamApi.save(
                    aRacingTeam()
                            .withDrivers(driverA, driverB)
            );

            mock.perform(
                            get("/api/racing-team/{id}/drivers", team.id().raw())
                                    .accept(APPLICATION_JSON)
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(APPLICATION_JSON))
                    .andExpect(jsonPath("$.length()", equalTo(2)))
                    .andExpect(jsonPath("$[0].name", equalTo("Arthur Dent")))
                    .andExpect(jsonPath("$[1].name", equalTo("Speed Racer")));
        }
    }
}

package de.comsystoreply.spring.core.bootcamp.adapter.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureWebMvc
class RacingTeamControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mock;

    @BeforeEach
    void setupMockMvc() {
        mock = MockMvcBuilders.webAppContextSetup(applicationContext)
                .build();
    }

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

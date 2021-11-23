package de.comsystoreply.spring.core.bootcamp.health;

import org.junit.jupiter.api.Test;

import de.comsystoreply.spring.core.bootcamp.WebMvcIntegrationTest;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HealthControllerTest extends WebMvcIntegrationTest {

    /*
     * no implementation needed health endpoint is part of Spring Boot Actuator.
     */

    @Test
    void getHealth() throws Exception {
        mock.perform(
                        get("/actuator/health")
                                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.status", equalTo("UP")));
    }
}

package de.comsystoreply.spring.core.bootcamp.health;

import de.comsystoreply.spring.core.bootcamp.config.TestDatabaseConfig;
import de.comsystoreply.spring.core.bootcamp.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringJUnitWebConfig({
        HealthConfig.class,
        WebConfig.class,
        TestDatabaseConfig.class
})
class HealthControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mock;

    @BeforeEach
    void setup() {
        /*
         * we need to wait until just before the test to create our MockMvc to ensure the WebApplicationContext was
         * created and injected into the test class.
         */
        mock = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("'/health' endpoint is available and returns 'getStatus' is 'up'")
    void getHealth() throws Exception {
        mock.perform(
                get("/health")
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.status", equalTo("UP")));
    }
}

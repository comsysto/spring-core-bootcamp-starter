package de.comsystoreply.spring.core.bootcamp;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureWebMvc
public abstract class WebMvcIntegrationTest extends IntegrationTest {

    @Autowired
    private WebApplicationContext applicationContext;

    protected MockMvc mock;

    @BeforeEach
    void setupMockMvc() {
        mock = MockMvcBuilders.webAppContextSetup(applicationContext)
                .build();
    }
}

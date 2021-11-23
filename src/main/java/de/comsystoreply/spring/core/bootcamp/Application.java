package de.comsystoreply.spring.core.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main class of the application.
 */
@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
public class Application {

    /**
     * Main method that acts as the entry point into the application.
     *
     * @param args the command line arguments the application is started with
     * @throws Exception any kind of exception will just be thrown up resulting in the application crashing
     */
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

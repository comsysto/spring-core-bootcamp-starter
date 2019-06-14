package de.comsystoreply.spring.core.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Import(JPAConfig.class)
public class TestDatabaseConfig {

    /**
     * An embedded {@code DataSource} to be used in test cases.
     * <p>
     * For our test cases we want to use an embedded (= in memory) {@code DataSource} to ensure we can easily run them
     * without bothering to setup infrastructure first. It also allows us to always start from a clean empty database
     * to help isolate individual test runs. And as a final benefit when running multiple tests in parallel (e.g. on a
     * CI server) we will never get into issues with the test runs interacting via the DB in some strange way.
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
}

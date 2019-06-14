package de.comsystoreply.spring.core.bootcamp.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(JPAConfig.class)
public class DatabaseConfig {

    /**
     * Postgres database running in a local docker container.
     */
    @Bean
    public DataSource postgresDataSource() {
        /*
         * Normally you would of course not hard code the DB credentials especially not the username and password but
         * fetch them from some kind of configuration. Here we just do this to get things up and running faster.
         *
         * If you change the credentials please ensure to also update what is set in 'docker-compose.yml'.
         */

        var dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(15432);
        dataSource.setUser("ninja-guy");
        dataSource.setPassword("inTheSh4d0ws");

        return dataSource;
    }
}

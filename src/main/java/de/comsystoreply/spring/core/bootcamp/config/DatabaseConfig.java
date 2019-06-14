package de.comsystoreply.spring.core.bootcamp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.Driver;
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

        var config = new HikariConfig();
        config.setDriverClassName(Driver.class.getCanonicalName());
        config.setJdbcUrl("jdbc:postgresql://localhost:15432/");
        config.setUsername("ninja-guy");
        config.setPassword("inTheSh4d0ws");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}

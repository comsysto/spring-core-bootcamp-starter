package de.comsystoreply.spring.core.bootcamp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

@Configuration
@Profile("postgres")
public class PostgresDataSourceConfig{

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl("jdbc:postgresql://localhost:15432/");
        driver.setUsername("ninja-guy");
        driver.setPassword("inTheSh4d0ws");
        return driver;
    }

    @Bean
    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");

        return properties;
    }
}

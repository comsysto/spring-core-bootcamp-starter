package de.comsystoreply.spring.core.bootcamp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;

@Configuration
@Profile("postgres")
@PropertySource("classpath:application-postgres.properties")
public class PostgresDataSourceConfig{

    @Bean
    public DataSource dataSource(
      @Value("${app.postgres.url}") String url,
      @Value("${app.postgres.user}") String user,
      @Value("${app.postgres.password}") String pw
    ) {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl(url);
        driver.setUsername(user);
        driver.setPassword(pw);
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

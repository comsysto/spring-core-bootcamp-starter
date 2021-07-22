package de.comsystoreply.spring.core.bootcamp.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DataSourceConfiguration {

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.setDriverClass(org.postgresql.Driver.class);
    dataSource.setUrl("jdbc:postgresql://localhost:15432/");
    dataSource.setUsername("ninja-guy");
    dataSource.setPassword("inTheSh4d0ws");
    return dataSource;
  }
}

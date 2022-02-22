package de.comsystoreply.springtrainingdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.comsystoreply.springtrainingdemo.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
public class DriverConfig {
    @Bean
    public ObjectMapper objectMapper(DriverConfigProperties driverConfigProperties) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(driverConfigProperties.getFormatString()));
        return objectMapper;
    };
}

package de.comsystoreply.springtrainingdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.comsystoreply.springtrainingdemo.model.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
public class DriverConfig {
    @Bean("CustomDateObjectMapper")
    public ObjectMapper driverConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    };

    @Primary
    @Bean("SecondCustomDateObjectMapper")
    public ObjectMapper secondDriverConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yy-MM-dd HH:mm"));
        return objectMapper;
    };
}

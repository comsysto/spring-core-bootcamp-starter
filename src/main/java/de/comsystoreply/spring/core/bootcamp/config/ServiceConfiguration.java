package de.comsystoreply.spring.core.bootcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "de.comsystoreply.spring.core.bootcamp.service")
public class ServiceConfiguration {
}

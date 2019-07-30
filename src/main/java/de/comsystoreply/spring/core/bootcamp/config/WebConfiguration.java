package de.comsystoreply.spring.core.bootcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "de.comsystoreply.spring.core.bootcamp.controller")
public class WebConfiguration {
}

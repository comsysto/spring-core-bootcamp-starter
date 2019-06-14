package de.comsystoreply.spring.core.bootcamp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for Spring Web MVC.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
}

package de.comsystoreply.springtrainingdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dateformat")
public class DriverConfigProperties {
    private String formatString;

    public String getFormatString() {
        return this.formatString;
    }

    public void setFormatString(String formatString) {
        this.formatString = formatString;
    }
}

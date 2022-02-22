package de.comsystoreply.springtrainingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RacingTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacingTeamApplication.class, args);
	}


}

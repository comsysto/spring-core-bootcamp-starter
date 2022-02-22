package de.comsystoreply.springtrainingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("prod")
public class RacingTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacingTeamApplication.class, args);
	}


}

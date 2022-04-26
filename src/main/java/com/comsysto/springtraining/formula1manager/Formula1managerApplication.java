package com.comsysto.springtraining.formula1manager;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.repository.DriverRepository;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import java.util.UUID;

@SpringBootApplication
public class Formula1managerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Formula1managerApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner setStartupData(RacingTeamRepository racingTeamRepository, DriverRepository driverRepository) {
//        return args -> {
//            RacingTeam team1 = new RacingTeam(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"), "Team 1");
//            var resultingTeam = racingTeamRepository.save(team1);
//
//            Driver driver1 = new Driver(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"),
//                    "first",
//                    "last",
//                    5,
//                ZonedDateTime.of(1990, 2, 1, 0, 0, 0, 0, ZoneId.of("America/Los_Angeles")), resultingTeam);
//            driverRepository.save(driver1);
//        };
//    }

    @Bean
    @Profile("America")
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder, @Value("$app.timezone") String timezone) {
        return builder.createXmlMapper(false).timeZone(timezone).build();
    }
}

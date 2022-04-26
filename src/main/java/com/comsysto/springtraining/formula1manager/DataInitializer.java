package com.comsysto.springtraining.formula1manager;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.repository.DriverRepository;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RacingTeamRepository racingTeamRepository;
    private final DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {
        RacingTeam team1 = new RacingTeam(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"), "Team 1");
        var resultingTeam = racingTeamRepository.save(team1);

        Driver driver1 = new Driver(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"),
                "first",
                "last",
                5,
                ZonedDateTime.of(1990, 2, 1, 0, 0, 0, 0, ZoneId.of("America/Los_Angeles")), resultingTeam);
        driverRepository.save(driver1);
    }
}

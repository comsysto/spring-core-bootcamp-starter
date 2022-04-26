package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RacingTeamServiceIF {

    RacingTeam createRacingTeam(RacingTeam racingTeam);

    List<RacingTeam> getAllRacingTeams();

    Optional<RacingTeam> getRacingTeamById(UUID teamId);

    Optional<Driver> createDriver(UUID racingTeamId, Driver driver);

    List<Driver> getAllDriversByRacingTeamId(UUID id);

    List<Driver> getAllDrivers();

}

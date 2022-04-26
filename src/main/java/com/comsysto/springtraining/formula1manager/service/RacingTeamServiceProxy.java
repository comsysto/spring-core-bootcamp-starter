package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@RequiredArgsConstructor
public class RacingTeamServiceProxy implements RacingTeamServiceIF {

    private final RacingTeamService racingTeamService;
    private final TransactionTemplate transactionTemplate;

    @Override
    public RacingTeam createRacingTeam(
            RacingTeam racingTeam) {
        transactionTemplate.execute()
        return racingTeamService.createRacingTeam(racingTeam);
    }

    @Override
    public List<RacingTeam> getAllRacingTeams() {
        return racingTeamService.getAllRacingTeams();
    }

    @Override
    public Optional<RacingTeam> getRacingTeamById(
            UUID teamId) {
        return racingTeamService.getRacingTeamById(teamId);
    }

    @Override
    public Optional<Driver> createDriver(
            UUID racingTeamId,
            Driver driver) {
        return racingTeamService.createDriver(racingTeamId, driver);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Driver> getAllDriversByRacingTeamId(
            UUID id) {
        return racingTeamService.getAllDriversByRacingTeamId(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return racingTeamService.getAllDrivers();
    }

}

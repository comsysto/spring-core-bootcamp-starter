package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;

import com.comsysto.springtraining.formula1manager.repository.DriverRepository;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RacingTeamService {
    private final RacingTeamRepository racingTeamRepository;
    private final DriverRepository driverRepository;

    public RacingTeam createRacingTeam(RacingTeam racingTeam) {
        return racingTeamRepository.save(racingTeam);
    }

    public List<RacingTeam> getAllRacingTeams() {
        return racingTeamRepository.findAll();
    }

    public Optional<RacingTeam> getRacingTeamById(UUID teamId) {
        return racingTeamRepository.findById(teamId);
    }

    @Transactional()
    public Optional<Driver> createDriver(UUID racingTeamId, Driver driver) {

        var racingTeam = getRacingTeamById(racingTeamId);
        if(racingTeam.isEmpty()) {
            return Optional.empty();
        }
        driver.setRacingTeam(racingTeam.get());

        Optional<Driver> optDriver = Optional.of(driverRepository.save(driver));
        if(optDriver.get().getAge() == 50) {
            throw new RuntimeException();
        }
        return optDriver;
    }

    @Transactional(readOnly = true)
    public List<Driver> getAllDriversByRacingTeamId(UUID id) {
        return driverRepository.findAllByRacingTeamId(id);
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}

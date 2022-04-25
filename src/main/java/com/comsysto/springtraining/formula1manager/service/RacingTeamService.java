package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;

import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.multi.MultiDesktopIconUI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RacingTeamService {
    private final UuidService uuidService;
    private final RacingTeamRepository racingTeamRepository;

    public RacingTeam createRacingTeam(RacingTeam racingTeam) {
//        racingTeam.setId(uuidService.generateUuid());
        return racingTeamRepository.save(racingTeam);
    }

    public List<RacingTeam> getAllRacingTeams() {
        return racingTeamRepository.findAll();
    }

    public Optional<RacingTeam> getRacingTeamById(UUID teamId) {
        return racingTeamRepository.findById(teamId);
    }

    public Optional<Driver> createDriver(UUID racingTeamId, Driver driver) {
//        driver.setId(uuidService.generateUuid());
        var racingTeam = getRacingTeamById(racingTeamId);
        if(racingTeam.isEmpty()) {
            return Optional.empty();
        }
        driver.setRacingTeam(racingTeam.get());
        racingTeam.get().getDrivers().add(driver);
        racingTeamRepository.save(racingTeam.get());
        return Optional.of(driver);
    }
}

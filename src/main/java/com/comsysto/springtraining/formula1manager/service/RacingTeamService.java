package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;

import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RacingTeamService {
    private final UuidService uuidService;
    private final RacingTeamRepository racingTeamRepository;

    public RacingTeam createRacingTeam(RacingTeam racingTeam) {
        racingTeam.setId(uuidService.generateUuid());
        return racingTeamRepository.save(racingTeam);
    }

    public List<RacingTeam> getAllRacingTeams() {
        return racingTeamRepository.findAll();
    }
}

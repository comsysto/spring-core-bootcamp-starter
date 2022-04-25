package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RacingTeamService {
    private final UuidService uuidService;

    public RacingTeam createRacingTeam(RacingTeam racingTeam) {
        racingTeam.setId(uuidService.generateUuid());
        return racingTeam;
    }
}

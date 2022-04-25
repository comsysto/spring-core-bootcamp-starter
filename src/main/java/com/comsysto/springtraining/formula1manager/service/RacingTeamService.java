package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RacingTeamService {

    public RacingTeam createRacingTeam(RacingTeam racingTeam) {
        UUID id = UUID.randomUUID();
        racingTeam.setId(id);
        return racingTeam;
    }
}

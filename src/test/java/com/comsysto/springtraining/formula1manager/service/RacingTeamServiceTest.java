package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RacingTeamServiceTest {

    private final RacingTeamService racingTeamService;

    @Test
    void createRacingTeamShouldWork() {
        RacingTeam team = new RacingTeam(null, "1");
    }
}
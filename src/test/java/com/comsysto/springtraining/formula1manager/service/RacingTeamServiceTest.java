package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RacingTeamServiceTest {
    private final UuidService uuidService = Mockito.mock(UuidService.class);

    private final RacingTeamService racingTeamService = new RacingTeamService(uuidService);

    @Test
    void createRacingTeamShouldWork() {
        when(uuidService.generateUuid()).then(new UUID(1L, 2L));
        RacingTeam team = new RacingTeam(null, "1");
        var resultingTeam = racingTeamService.createRacingTeam(team);
        assertNotNull(team.getId());
    }
}
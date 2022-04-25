package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RacingTeamServiceTest {
    private final UuidService uuidService = Mockito.mock(UuidService.class);

    private final RacingTeamService racingTeamService = new RacingTeamService(uuidService);

    @Test
    void createRacingTeamShouldWork() {
        UUID uuid = new UUID(1L, 2L);
        when(uuidService.generateUuid()).thenReturn(uuid);
        RacingTeam expectedTeam = new RacingTeam(uuid, "1");

        RacingTeam racingTeam = new RacingTeam(null, "1");
        var resultingTeam = racingTeamService.createRacingTeam(racingTeam);
//        assertEquals(uuid, racingTeam.getId());
        assertThat(resultingTeam).isEqualTo(expectedTeam);
    }
}
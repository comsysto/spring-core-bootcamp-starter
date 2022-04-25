package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RacingTeamServiceTest {

    @Mock
    private UuidService uuidService;

    @Mock
    private RacingTeamRepository racingTeamRepository;

    @InjectMocks
    private RacingTeamService racingTeamService;

    @Test
    void createRacingTeamShouldWork() {
        UUID uuid = new UUID(1L, 2L);
        RacingTeam expectedTeam = new RacingTeam(uuid, "1");

        when(uuidService.generateUuid()).thenReturn(uuid);
        when(racingTeamRepository.save(expectedTeam)).thenReturn(expectedTeam);

        RacingTeam racingTeam = new RacingTeam(null, "1");
        var resultingTeam = racingTeamService.createRacingTeam(racingTeam);
        assertThat(resultingTeam).isEqualTo(expectedTeam);
    }

}
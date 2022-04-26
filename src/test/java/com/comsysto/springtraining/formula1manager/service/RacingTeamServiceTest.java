package com.comsysto.springtraining.formula1manager.service;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.repository.DriverRepository;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RacingTeamServiceTest {
    @Mock
    private RacingTeamRepository racingTeamRepository;

    @Mock
    DriverRepository driverRepository;

    @InjectMocks
    private RacingTeamService racingTeamService;

    private final UUID uuid = UUID.randomUUID();

    @Test
    void createRacingTeamShouldWork() {
        RacingTeam inputTeam = new RacingTeam(null, "1");
        RacingTeam expectedTeam = new RacingTeam(uuid, "1");
        when(racingTeamRepository.save(inputTeam)).thenReturn(expectedTeam);

        var resultingTeam = racingTeamService.createRacingTeam(inputTeam);
        assertThat(resultingTeam).isEqualTo(expectedTeam);
    }

    @Test
    void createDriver_shouldReturnDriverWithId() {
        var racingTeam = new RacingTeam(uuid, "Mercedes");
        var inputDriver = new Driver(null, "First", "Last", 20, null, null);
        var inputDriverWithTeam = new Driver(null, "First", "Last", 20, null, racingTeam);
        var expectedDriver = new Driver(uuid, "First", "Last", 20, null, racingTeam);
        when(racingTeamRepository.findById(uuid)).thenReturn(Optional.of(racingTeam));
        when(driverRepository.save(inputDriverWithTeam)).thenReturn(expectedDriver);

        var resultingDriver = racingTeamService.createDriver(uuid, inputDriver);
        assertThat(resultingDriver).get().isEqualTo(expectedDriver);
    }

}
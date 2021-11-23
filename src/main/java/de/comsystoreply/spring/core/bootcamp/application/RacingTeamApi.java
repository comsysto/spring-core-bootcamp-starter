package de.comsystoreply.spring.core.bootcamp.application;

import java.util.Optional;

import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

public interface RacingTeamApi {

    RacingTeam createNewRacingTeam(String name);

    RacingTeam save(RacingTeam racingTeam);

    Optional<RacingTeam> findById(Id<RacingTeam> racingTeamId);
}

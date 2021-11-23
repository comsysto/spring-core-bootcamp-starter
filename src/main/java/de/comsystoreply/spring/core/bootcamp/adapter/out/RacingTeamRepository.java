package de.comsystoreply.spring.core.bootcamp.adapter.out;

import java.util.Optional;

import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

public interface RacingTeamRepository {

    RacingTeam save(RacingTeam racingTeam);

    Optional<RacingTeam> findById(Id<RacingTeam> racingTeamId);
}

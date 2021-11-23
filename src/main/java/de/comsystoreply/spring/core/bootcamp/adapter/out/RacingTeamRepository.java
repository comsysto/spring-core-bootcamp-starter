package de.comsystoreply.spring.core.bootcamp.adapter.out;

import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

public interface RacingTeamRepository {

    RacingTeam save(RacingTeam racingTeam);
}

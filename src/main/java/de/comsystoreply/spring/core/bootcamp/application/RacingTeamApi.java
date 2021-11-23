package de.comsystoreply.spring.core.bootcamp.application;

import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

public interface RacingTeamApi {

    RacingTeam createNewRacingTeam(String name);

    RacingTeam save(RacingTeam racingTeam);
}

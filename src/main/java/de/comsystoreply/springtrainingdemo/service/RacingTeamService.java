package de.comsystoreply.springtrainingdemo.service;

import de.comsystoreply.springtrainingdemo.model.Driver;
import de.comsystoreply.springtrainingdemo.model.RacingTeam;

public class RacingTeamService {

    public RacingTeam createRacingTeam(String teamName) {

        return new RacingTeam(teamName);
    }

    public void saveRacingTeam(RacingTeam racingTeam) {

    }

}

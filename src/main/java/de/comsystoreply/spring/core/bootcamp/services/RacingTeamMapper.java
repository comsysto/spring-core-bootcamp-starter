package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.web.model.RacingTeamResource;

public class RacingTeamMapper {

    public static RacingTeam fromResource(RacingTeamResource racingTeamResource) {
        return new RacingTeam(racingTeamResource.getName());
    }

    public static RacingTeamResource toResource(RacingTeam racingTeam) {
        if(racingTeam == null) {
            return null;
        }
        return new RacingTeamResource(racingTeam.getName());
    }
}

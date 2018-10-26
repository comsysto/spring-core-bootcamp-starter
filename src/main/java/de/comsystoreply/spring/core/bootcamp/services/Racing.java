package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.web.model.RacingTeamResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface Racing {

    RacingTeamResource createRacingTeam(String name);

    RacingTeamResource modifyTeamByName(String oldName, String newName);

    Optional<RacingTeamResource> getRacingTeamByName(String name);

    List<RacingTeamResource> getAllRacingTeams();

    void deleteRacingTeamByName(String name);

    void deleteAllRacingTeams();
}

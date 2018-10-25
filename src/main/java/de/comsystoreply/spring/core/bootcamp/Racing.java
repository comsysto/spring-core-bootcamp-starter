package de.comsystoreply.spring.core.bootcamp;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;

import java.util.List;
import java.util.Optional;

public interface Racing {

    RacingTeam createRacingTeam(String name);

    void deleteRacingTeamByName(String name);

    RacingTeam modifyTeamByName(String oldName, String newName);

    Optional<RacingTeam> getRacingTeamByName(String name);

    List<RacingTeam> getAllRacingTeams();

    void deleteAllRacingTeams();
}

package de.comsystoreply.spring.core.bootcamp.repo;

import de.comsystoreply.spring.core.bootcamp.racingteam.RacingTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RacingTeamRepository extends CrudRepository<RacingTeam,Long> {

    @Override
    List<RacingTeam> findAll();


}

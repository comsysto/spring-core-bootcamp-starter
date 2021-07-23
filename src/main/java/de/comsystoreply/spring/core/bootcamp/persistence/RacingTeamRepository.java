package de.comsystoreply.spring.core.bootcamp.persistence;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;
import java.util.List;


public interface RacingTeamRepository extends CrudRepository<RacingTeam, Long> {

    @Override
    @Transactional(readOnly = true)
    public List<RacingTeam> findAll();

}

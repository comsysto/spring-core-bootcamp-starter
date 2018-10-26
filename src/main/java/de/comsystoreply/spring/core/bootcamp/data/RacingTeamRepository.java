package de.comsystoreply.spring.core.bootcamp.data;

import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacingTeamRepository extends JpaRepository<RacingTeam, Long> {


}


package com.comsysto.springtraining.formula1manager.repository;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface RacingTeamRepository extends CrudRepository<RacingTeam, UUID> {

}

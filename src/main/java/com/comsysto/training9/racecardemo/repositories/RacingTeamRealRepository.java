package com.comsysto.training9.racecardemo.repositories;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface RacingTeamRealRepository extends CrudRepository<RacingTeamEntity, Long> {

}

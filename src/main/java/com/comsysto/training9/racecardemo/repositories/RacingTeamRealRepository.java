package com.comsysto.training9.racecardemo.repositories;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RacingTeamRealRepository extends CrudRepository<RacingTeamEntity, Long> {

  @Override
  List<RacingTeamEntity> findAll();
}

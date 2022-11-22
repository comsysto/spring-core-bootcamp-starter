package com.comsysto.training9.racecardemo.services;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import java.util.List;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.springframework.stereotype.Component;

@Component
public class JpaRacingTeamDataService implements RacingTeamDataService{

  private final RacingTeamRealRepository racingTeamRealRepository;

  public JpaRacingTeamDataService(
      RacingTeamRealRepository racingTeamRealRepository) {
    this.racingTeamRealRepository = racingTeamRealRepository;
  }


  @Override
  public RacingTeamModel save(RacingTeamModel racingTeamModel) {
    return toRacingTeamModel(racingTeamRealRepository.save(toRacingTeamEntity(racingTeamModel)));
  }

  @Override
  public List<RacingTeamModel> findAll() {
    return null;
  }

  @Override
  public RacingTeamModel findById(long id) {
    return null;
  }

  private RacingTeamEntity toRacingTeamEntity(RacingTeamModel racingTeamModel) {
    var entity = new RacingTeamEntity();
    entity.setId(racingTeamModel.getId());
    entity.setName(racingTeamModel.getName());
    return entity;
  }

  private static RacingTeamModel toRacingTeamModel(RacingTeamEntity racingTeamEntity) {
    return new RacingTeamModel(racingTeamEntity.getId(), racingTeamEntity.getName());
  }
}

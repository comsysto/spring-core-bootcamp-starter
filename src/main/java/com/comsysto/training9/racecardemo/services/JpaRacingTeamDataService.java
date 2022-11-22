package com.comsysto.training9.racecardemo.services;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("jpa")
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
    return racingTeamRealRepository.findAll().stream()
            .map(JpaRacingTeamDataService::toRacingTeamModel)
            .collect(Collectors.toList());
  }

  @Override
  public Optional<RacingTeamModel> findById(long id) {
    return racingTeamRealRepository.findById(id)
            .map(JpaRacingTeamDataService::toRacingTeamModel);
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

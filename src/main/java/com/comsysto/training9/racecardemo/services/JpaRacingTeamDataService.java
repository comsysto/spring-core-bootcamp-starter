package com.comsysto.training9.racecardemo.services;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import java.util.List;
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

    return null;
  }

  @Override
  public List<RacingTeamModel> findAll() {
    return null;
  }

  @Override
  public RacingTeamModel findById(long id) {
    return null;
  }
}

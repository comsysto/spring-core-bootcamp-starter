package com.comsysto.training9.racecardemo.services;

import static org.junit.jupiter.api.Assertions.*;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import org.junit.jupiter.api.Test;

class RacingTeamDataServiceTest {

  private JpaRacingTeamDataService jpaRacingTeamDataService;


  @Test
  void testSave(){
    RacingTeamModel racingTeamModel = new RacingTeamModel(9999L,"name");
    jpaRacingTeamDataService.save(racingTeamModel);

  }
}
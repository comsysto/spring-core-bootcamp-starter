package com.comsysto.training9.racecardemo.services;

import static org.junit.jupiter.api.Assertions.*;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class RacingTeamDataServiceTest {

  private JpaRacingTeamDataService jpaRacingTeamDataService;

  private RacingTeamRealRepository racingTeamRealRepository;

  @BeforeEach
  void initialize() {
    racingTeamRealRepository = Mockito.mock(RacingTeamRealRepository.class);
    jpaRacingTeamDataService = new JpaRacingTeamDataService(racingTeamRealRepository);
  }


  @Test
  void testSave(){
    RacingTeamModel racingTeamModel = new RacingTeamModel(9999L,"name");
    Mockito.when(racingTeamRealRepository.save(toRacingTeamEntity(racingTeamModel))).thenReturn(toRacingTeamEntity(racingTeamModel));
    jpaRacingTeamDataService.save(racingTeamModel);

  }
  private RacingTeamEntity toRacingTeamEntity(RacingTeamModel racingTeamModel) {
    var entity = new RacingTeamEntity();
    entity.setId(racingTeamModel.getId());
    entity.setName(racingTeamModel.getName());
    return entity;
  }
}
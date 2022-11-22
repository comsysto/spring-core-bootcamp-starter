package com.comsysto.training9.racecardemo.services;

import static org.junit.jupiter.api.Assertions.*;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class RacingTeamDataServiceTest {

    private JpaRacingTeamDataService jpaRacingTeamDataService;

    private RacingTeamRealRepository racingTeamRealRepository;
    private final RacingTeamModel racingTeamModel = new RacingTeamModel(9999L, "name");

    @BeforeEach
    void initialize() {
        racingTeamRealRepository = Mockito.mock(RacingTeamRealRepository.class);
        jpaRacingTeamDataService = new JpaRacingTeamDataService(racingTeamRealRepository);
    }


    @Test
    void testSave() {
        //given
        Mockito.when(racingTeamRealRepository.save(toRacingTeamEntity(racingTeamModel)))
                .thenReturn(toRacingTeamEntity(racingTeamModel));

        //when
        RacingTeamModel res = jpaRacingTeamDataService.save(racingTeamModel);

        //then
        Assertions.assertThat(res).isEqualTo(racingTeamModel);
    }

    private RacingTeamEntity toRacingTeamEntity(RacingTeamModel racingTeamModel) {
        var entity = new RacingTeamEntity();
        entity.setId(racingTeamModel.getId());
        entity.setName(racingTeamModel.getName());
        return entity;
    }
}
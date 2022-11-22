package com.comsysto.training9.racecardemo.repositories;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.comsysto.training9.racecardemo.services.RacingTeamDataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Profile("dummy")
public class DummyRacingTeamDataService implements RacingTeamDataService {
    private List<RacingTeamModel> racingTeamModelList = new ArrayList<>();

    @Override
    public RacingTeamModel save(RacingTeamModel racingTeamModel) {
        racingTeamModelList.add(racingTeamModel);
        return racingTeamModel;
    }

    @Override
    public List<RacingTeamModel> findAll() {

        return racingTeamModelList;
    }

    @Override
    public Optional<RacingTeamModel> findById(long id) {
        return racingTeamModelList
                .stream()
                .filter(racingTeamModel -> racingTeamModel.getId().equals(id))
                .findFirst();
    }
}

package com.comsysto.training9.racecardemo.services;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.ArrayList;
import java.util.List;

public interface RacingTeamDataService {

    public RacingTeamModel save(RacingTeamModel racingTeamModel);
    public List<RacingTeamModel> findAll();
    public RacingTeamModel findById(long id);

}

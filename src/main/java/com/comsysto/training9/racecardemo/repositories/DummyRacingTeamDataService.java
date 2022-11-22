package com.comsysto.training9.racecardemo.repositories;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import java.util.ArrayList;
import java.util.List;

import com.comsysto.training9.racecardemo.services.RacingTeamDataService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class DummyRacingTeamDataService implements RacingTeamDataService {
    private List<RacingTeamModel> racingTeamModelList = new ArrayList<>();
    @Override
    public RacingTeamModel save(RacingTeamModel racingTeamModel){
        racingTeamModelList.add(racingTeamModel);
        return racingTeamModel;
    }
    @Override
    public List<RacingTeamModel> findAll() {

        return racingTeamModelList;
    }
    @Override
    public RacingTeamModel findById(long id) {
        for(RacingTeamModel racingTeamRepository: racingTeamModelList){
            if(racingTeamRepository.getId().equals(id)){
                return racingTeamRepository;
            }
        }
        return null;
    }
}

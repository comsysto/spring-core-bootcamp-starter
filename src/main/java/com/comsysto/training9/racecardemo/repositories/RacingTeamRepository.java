package com.comsysto.training9.racecardemo.repositories;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RacingTeamRepository {
    private List<RacingTeamModel> racingTeamModelList = new ArrayList<>();

    public RacingTeamModel save(RacingTeamModel racingTeamModel){
        racingTeamModelList.add(racingTeamModel);
        return racingTeamModel;
    }

    public List<RacingTeamModel> findAll() {

        return racingTeamModelList;
    }

    public RacingTeamModel findById(long id) {
        for(RacingTeamModel racingTeamRepository: racingTeamModelList){
            if(racingTeamRepository.getId().equals(id)){
                return racingTeamRepository;
            }
        }
        return null;
    }
}

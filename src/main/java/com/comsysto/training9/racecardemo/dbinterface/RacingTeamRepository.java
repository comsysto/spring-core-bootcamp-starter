package com.comsysto.training9.racecardemo.dbinterface;

import com.comsysto.training9.racecardemo.model.RacingTeamModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

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

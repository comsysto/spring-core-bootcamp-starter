package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.dbinterface.RacingTeamRepository;
import com.comsysto.training9.racecardemo.model.RacingTeamModel;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class RacingTeamsController {
  RacingTeamRepository racingTeamRepository;

  public RacingTeamsController(RacingTeamRepository racingTeamRepository) {
    this.racingTeamRepository = racingTeamRepository;
  }

  @GetMapping("/racingteam/{id}")
  public RacingTeamModel getRacingTeam(@PathVariable long id){
    return racingTeamRepository.findById(id);
  }

  @PutMapping("/racingteam")
  public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel){

    return  racingTeamRepository.save(racingTeamModel);
  }


}

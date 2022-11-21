package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.model.RacingTeamModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class RacingTeamsController {

  @GetMapping("/racingteam/{id}")
  public RacingTeamModel getRacingTeam(@PathVariable long id){

    return new RacingTeamModel(id, "TeamSuperb");
  }

  @PutMapping("/racingteam/")
  public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel){
    //TODO save it somewhere
    return racingTeamModel;
  }


}

package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.model.RacingTeamModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class RacingTeamsController {

  @GetMapping("/racingteam/{id}")
  public RacingTeamModel getRacingTeam(@PathVariable long id){

    return new RacingTeamModel(id, "TeamSuperb");
  }

}

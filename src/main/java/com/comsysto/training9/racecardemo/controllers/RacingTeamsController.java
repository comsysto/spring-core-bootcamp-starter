package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.List;
import java.util.Optional;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import com.comsysto.training9.racecardemo.services.JpaRacingTeamDataService;
import com.comsysto.training9.racecardemo.services.RacingTeamDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racingteam")
public class RacingTeamsController {
    RacingTeamDataService jpaRacingTeamDataService;

    public RacingTeamsController(RacingTeamDataService racingTeamRepository) {
        this.jpaRacingTeamDataService = racingTeamRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<RacingTeamModel> getRacingTeam(@PathVariable long id) {
        return jpaRacingTeamDataService.findById(id)
            .map(racingTeamModel -> ResponseEntity.ok(racingTeamModel))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<RacingTeamModel> getRacingTeams() {
        return jpaRacingTeamDataService.findAll();
    }

    @PutMapping()
    public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel) {
        return jpaRacingTeamDataService.save(racingTeamModel);
    }
}

package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.dbinterface.RacingTeamRepository;
import com.comsysto.training9.racecardemo.model.RacingTeamModel;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racingteam")
public class RacingTeamsController {
    RacingTeamRepository racingTeamRepository;

    public RacingTeamsController(RacingTeamRepository racingTeamRepository) {
        this.racingTeamRepository = racingTeamRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<RacingTeamModel> getRacingTeam(@PathVariable long id) {
        RacingTeamModel byId = racingTeamRepository.findById(id);
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId);
    }

    @GetMapping()
    public List<RacingTeamModel> getRacingTeams() {
        return racingTeamRepository.findAll();
    }

    @PutMapping()
    public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel) {
        return racingTeamRepository.save(racingTeamModel);
    }
}

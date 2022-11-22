package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import com.comsysto.training9.racecardemo.repositories.RacingTeamRepository;
import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racingteam")
public class RacingTeamsController {
    RacingTeamRealRepository racingTeamRepository;

    public RacingTeamsController(RacingTeamRealRepository racingTeamRepository) {
        this.racingTeamRepository = racingTeamRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<RacingTeamModel> getRacingTeam(@PathVariable long id) {
        Optional<RacingTeamEntity> byId = racingTeamRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toRacingTeamModel(byId.get()));
    }

    private static RacingTeamModel toRacingTeamModel(RacingTeamEntity byId) {
        return new RacingTeamModel(byId.getId(), byId.getName());
    }

    @GetMapping()
    public List<RacingTeamModel> getRacingTeams() {
        ArrayList<RacingTeamModel> list = new ArrayList<>();
        racingTeamRepository.findAll().forEach(i -> list.add(toRacingTeamModel(i)));
        return list;
    }

    @PutMapping()
    public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel) {
        return racingTeamRepository.save(racingTeamModel);
    }
}

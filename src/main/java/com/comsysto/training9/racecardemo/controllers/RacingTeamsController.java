package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private static RacingTeamModel toRacingTeamModel(RacingTeamEntity racingTeamEntity) {
        return new RacingTeamModel(racingTeamEntity.getId(), racingTeamEntity.getName());
    }

    @GetMapping()
    public List<RacingTeamModel> getRacingTeams() {
        return racingTeamRepository.findAll().stream()
                .map(RacingTeamsController::toRacingTeamModel)
                .collect(Collectors.toList());
    }

    @PutMapping()
    public RacingTeamModel putRacingTeam(@RequestBody RacingTeamModel racingTeamModel) {
        var entity = new RacingTeamEntity();
        entity.setId(racingTeamModel.getId());
        entity.setName(racingTeamModel.getName());
        RacingTeamEntity savedEntity = racingTeamRepository.save(entity);
        return toRacingTeamModel(savedEntity);
    }
}

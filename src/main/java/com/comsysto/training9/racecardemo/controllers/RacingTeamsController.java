package com.comsysto.training9.racecardemo.controllers;

import com.comsysto.training9.racecardemo.repositories.RacingTeamRealRepository;
import com.comsysto.training9.racecardemo.controllers.model.RacingTeamModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.comsysto.training9.racecardemo.repositories.entity.RacingTeamEntity;
import com.comsysto.training9.racecardemo.services.JpaRacingTeamDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/racingteam")
public class RacingTeamsController {
    JpaRacingTeamDataService racingTeamRepository;

    public RacingTeamsController(JpaRacingTeamDataService racingTeamRepository) {
        this.racingTeamRepository = racingTeamRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<RacingTeamModel> getRacingTeam(@PathVariable long id) {
        Optional<RacingTeamModel> byId = racingTeamRepository.findById(id)
                .map()
        return ;
    }

    private static RacingTeamModel toRacingTeamModel(RacingTeamEntity racingTeamEntity) {
        return new RacingTeamModel(racingTeamEntity.getId(), racingTeamEntity.getName());
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

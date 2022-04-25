package com.comsysto.springtraining.formula1manager.controller;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.service.RacingTeamService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/racingteams")
@RequiredArgsConstructor
public class RacingTeamController {

    private final RacingTeamService racingTeamService;

    @GetMapping
    public List<RacingTeam> getAllRacingTeams () {
        return racingTeamService.getAllRacingTeams();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RacingTeam createRacingTeam(@RequestBody RacingTeam team) {
        return racingTeamService.createRacingTeam(team);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RacingTeam> getRacingTeamById(@PathVariable UUID id) {
        return ResponseEntity.of(racingTeamService.getRacingTeamById(id));
    }
}

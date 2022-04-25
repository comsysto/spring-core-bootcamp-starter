package com.comsysto.springtraining.formula1manager.controller;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.service.RacingTeamService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        List<RacingTeam> teams = new ArrayList<>();
        teams.add(new RacingTeam(UUID.randomUUID(), "test"));
        return teams;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RacingTeam createRacingTeam(@RequestBody RacingTeam team) {
        var createdTeam = racingTeamService.createRacingTeam(team);
        return createdTeam;
    }
}

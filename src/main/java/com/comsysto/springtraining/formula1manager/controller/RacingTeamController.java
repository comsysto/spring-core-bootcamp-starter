package com.comsysto.springtraining.formula1manager.controller;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/racingteams")
public class RacingTeamController {
    @GetMapping
    public List<RacingTeam> getAllRacingTeams () {
        List<RacingTeam> teams = new ArrayList<>();
        teams.add(new RacingTeam(1L, "test"));
        return teams;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RacingTeam createRacingTeam(@RequestBody RacingTeam team) {
        return team;
    }
}

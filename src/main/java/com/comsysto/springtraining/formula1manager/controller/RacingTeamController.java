package com.comsysto.springtraining.formula1manager.controller;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RacingTeamController {
    @GetMapping("/")
    public List<RacingTeam> getAllRacingTeams () {
        return
    }
}

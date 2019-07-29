package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.racingteam.RacingTeam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/racingteam")
public class RacingTeamController {

    @GetMapping
    public ResponseEntity<RacingTeam> get(@RequestParam long id) {

        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List< RacingTeam>> list() {

        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    public ResponseEntity<RacingTeam> save() {

        return ResponseEntity.ok(null);
    }



}

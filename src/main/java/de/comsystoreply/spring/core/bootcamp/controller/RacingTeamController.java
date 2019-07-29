package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.racingteam.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.repo.RacingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/racingteam", produces = APPLICATION_JSON_UTF8_VALUE)
public class RacingTeamController {
    
    @Autowired
    private RacingTeamRepository racingTeamRepo;

    @GetMapping("/{id}")
    public ResponseEntity<RacingTeam> get(@PathVariable long id) {
        Optional<RacingTeam> racingTeam = racingTeamRepo.findById(id);
        return ResponseEntity.ok(racingTeam.orElse(null));
    }

    @GetMapping
    public ResponseEntity<List< RacingTeam>> list() {
        Iterable<RacingTeam> all = racingTeamRepo.findAll();
        new ArrayList(all);
        Collections.
        return ResponseEntity.ok(List.);
    }

    @PostMapping
    public ResponseEntity<RacingTeam> save( @RequestBody RacingTeam racingTeam ) {

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {

        return ResponseEntity.ok(id);
    }


}

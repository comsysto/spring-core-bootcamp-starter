package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.service.RacingTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/racingteam", produces = APPLICATION_JSON_UTF8_VALUE)
public class RacingTeamController {
    
    @Autowired
    private RacingTeamService racingTeamService;

    @GetMapping("/{id}")
    public ResponseEntity<RacingTeam> get(@PathVariable long id) {
        RacingTeam racingTeam = racingTeamService.findById(id);
        return ResponseEntity.ok(racingTeam);
    }

    @GetMapping
    public ResponseEntity<List< RacingTeam>> list() {
        List<RacingTeam> allList = racingTeamService.findAll();
        return ResponseEntity.ok(allList);
    }

    @PostMapping
    public ResponseEntity<RacingTeam> save( @RequestBody RacingTeam racingTeam ) {
        RacingTeam savedRacingTeam = racingTeamService.save(racingTeam);
        return ResponseEntity.ok(savedRacingTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {
        racingTeamService.delete(id);
        return ResponseEntity.ok(id);
    }


}

package de.comsystoreply.spring.core.bootcamp.controller;

import de.comsystoreply.spring.core.bootcamp.racingteam.RacingTeam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/racingteam", produces = APPLICATION_JSON_UTF8_VALUE)
public class RacingTeamController {

    @GetMapping("/{id}")
    public ResponseEntity<RacingTeam> get(@PathVariable long id) {

        return ResponseEntity.ok(new RacingTeam(id,"Name", List.of(), List.of()));
    }

    @GetMapping
    public ResponseEntity<List< RacingTeam>> list() {

        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    public ResponseEntity<RacingTeam> save( @RequestBody RacingTeam racingTeam ) {

        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Long> delete(@RequestParam long id) {

        return ResponseEntity.ok(id);
    }


}

package de.comsystoreply.spring.core.bootcamp.web;

import de.comsystoreply.spring.core.bootcamp.services.Racing;
import de.comsystoreply.spring.core.bootcamp.web.model.RacingTeamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/racingTeams", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class RacingTeamController {

    final Racing service;

    @Autowired
    public RacingTeamController(Racing service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RacingTeamResource createRacingTeam(@RequestBody RacingTeamResource team) {
        return service.createRacingTeam(team.getName());
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRacingTeamByName(@PathVariable String name) {
        service.deleteRacingTeamByName(name);
    }

    @PutMapping("/{name}")
    public RacingTeamResource modifyTeamByName(@PathVariable("name") String oldName, @RequestBody RacingTeamResource team) {
      return service.modifyTeamByName(oldName, team.getName());
    }

    @GetMapping("/{name}")
    public ResponseEntity<RacingTeamResource> getRacingTeamByName(@PathVariable String name) {
        return service.getRacingTeamByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<RacingTeamResource> getAllRacingTeams() {
        return service.getAllRacingTeams();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllRacingTeams() {
        service.deleteAllRacingTeams();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<Object> handleIllegalArgumentException() {
        return ResponseEntity.notFound().build();
    }
}

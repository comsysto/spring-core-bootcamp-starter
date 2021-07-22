package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.persistence.RacingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RacingTeamController {

    private final RacingTeamRepository racingTeamRepository;

    @Autowired
    public RacingTeamController(RacingTeamRepository rtr) {
        this.racingTeamRepository = rtr;
    }

    @GetMapping("/teams")
    public Iterable<RacingTeam> getTeams() {
        return racingTeamRepository.findAll();
    }

}

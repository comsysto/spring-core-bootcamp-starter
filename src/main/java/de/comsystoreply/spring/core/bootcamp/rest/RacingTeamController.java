package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.persistence.RacingTeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RacingTeamController {

  @PersistenceContext
  private EntityManager entityManager;


  @GetMapping("/teams")
  public String getTeams() {
    return "All my teams!";
  }

}

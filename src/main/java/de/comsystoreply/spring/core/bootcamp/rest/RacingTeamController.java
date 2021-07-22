package de.comsystoreply.spring.core.bootcamp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RacingTeamController {

  @GetMapping("/teams")
  public String getTeams() {
    return "All my teams!";
  }

}

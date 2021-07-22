package de.comsystoreply.spring.core.bootcamp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@RestController
@PersistenceContext(PersistenceContextType.EXTENDED)
public class RacingTeamController {

  @PersistenceContext(PersistenceContextType.EXTENDED)
  private EntityManager entityManager;


  @GetMapping("/teams")
  public String getTeams() {
    return "All my teams!";
  }

}

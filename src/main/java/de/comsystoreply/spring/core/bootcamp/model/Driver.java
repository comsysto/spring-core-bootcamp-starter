package de.comsystoreply.spring.core.bootcamp.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
public class Driver {

  @Id
  @SequenceGenerator(name = "driver_generator",
      sequenceName = "DRIVER_SEQUENCE",
      allocationSize = 1)
  @GeneratedValue(generator = "driver_generator")
  private Long id;

  private String firstName;

  private String lastName;

  private LocalDate dateOfBirth;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "RACING_TEAM_ID", nullable = false)
  private RacingTeam racingTeam;
}

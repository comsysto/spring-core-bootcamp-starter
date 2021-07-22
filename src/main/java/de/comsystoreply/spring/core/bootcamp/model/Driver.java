package de.comsystoreply.spring.core.bootcamp.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "DRIVER")
public class Driver {

  @Id
  @SequenceGenerator(name = "driver_generator",
      sequenceName = "DRIVER_SEQUENCE",
      allocationSize = 1)
  @GeneratedValue(generator = "driver_generator")
  private Long id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "DATE_OF_BIRTH")
  private LocalDate dateOfBirth;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "RACING_TEAM_ID", nullable = false)
  private RacingTeam racingTeam;
}

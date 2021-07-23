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

  public Driver(Long id, String firstName, String lastName, LocalDate dateOfBirth, RacingTeam racingTeam) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.racingTeam = racingTeam;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public RacingTeam getRacingTeam() {
    return racingTeam;
  }

  public void setRacingTeam(RacingTeam racingTeam) {
    this.racingTeam = racingTeam;
  }
}

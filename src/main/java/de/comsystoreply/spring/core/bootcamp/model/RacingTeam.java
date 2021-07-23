package de.comsystoreply.spring.core.bootcamp.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RACING_TEAM")
public class RacingTeam {

  @Id
  @SequenceGenerator(name = "racing_team_generator",
      sequenceName = "RACING_TEAM_SEQUENCE",
      allocationSize = 1)
  @GeneratedValue(generator = "racing_team_generator")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Driver> drivers;

  private RacingTeam() {}

  public RacingTeam(Long id, String name, List<Driver> drivers) {
    this.id = id;
    this.name = name;
    this.drivers = drivers;
  }

  //  private List<RaceCar> raceCars;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Driver> getDrivers() {
    return drivers;
  }

  public void setDrivers(List<Driver> drivers) {
    this.drivers = drivers;
  }

//  public List<RaceCar> getRaceCars() {
//    return raceCars;
//  }

//  public void setRaceCars(List<RaceCar> raceCars) {
//    this.raceCars = raceCars;
//  }
}

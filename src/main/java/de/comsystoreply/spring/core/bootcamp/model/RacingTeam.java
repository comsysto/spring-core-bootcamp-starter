package de.comsystoreply.spring.core.bootcamp.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RacingTeam {

  private Long id;

  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Driver> drivers;

  private List<RaceCar> raceCars;

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

  public List<RaceCar> getRaceCars() {
    return raceCars;
  }

  public void setRaceCars(List<RaceCar> raceCars) {
    this.raceCars = raceCars;
  }
}

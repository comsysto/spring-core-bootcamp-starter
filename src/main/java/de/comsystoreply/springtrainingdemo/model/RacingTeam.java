package de.comsystoreply.springtrainingdemo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class RacingTeam {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<Driver> drivers;

    @OneToMany
    private List<RaceCar> raceCars;

    public RacingTeam() {
    }

    public RacingTeam(String name) {
        this.name = name;
        this.drivers = new ArrayList<>();
        this.raceCars = new ArrayList<>();
    }

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

package de.comsystoreply.spring.core.bootcamp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class RacingTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @OneToMany
    private List<Driver> drivers;
    @OneToMany
    private List<RaceCar> raceCars;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

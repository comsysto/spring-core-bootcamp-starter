package de.comsystoreply.spring.core.bootcamp.racingteam;

import java.util.List;

public class RacingTeam {
    private long id;
    private String name;
    private List<Driver> drivers;
    private List<RaceCar> raceCars;

    public RacingTeam(long id, String name, List<Driver> drivers, List<RaceCar> raceCars) {
        this.id = id;
        this.name = name;
        this.drivers = drivers;
        this.raceCars = raceCars;
    }

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

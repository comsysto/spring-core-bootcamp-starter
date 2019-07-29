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
}

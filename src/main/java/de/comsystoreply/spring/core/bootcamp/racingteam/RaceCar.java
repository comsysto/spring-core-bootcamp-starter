package de.comsystoreply.spring.core.bootcamp.racingteam;

public class RaceCar {
    private long id;
    private String title;
    private String description;
    private int horsePower;
    private float weightInKg;
    private RacingTeam racingTeam;

    public RaceCar(long id, String title, String description, int horsePower, float weightInKg, RacingTeam racingTeam) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.horsePower = horsePower;
        this.weightInKg = weightInKg;
        this.racingTeam = racingTeam;
    }
}

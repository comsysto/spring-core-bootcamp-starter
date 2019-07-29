package de.comsystoreply.spring.core.bootcamp.domain;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public float getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(float weightInKg) {
        this.weightInKg = weightInKg;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }
}

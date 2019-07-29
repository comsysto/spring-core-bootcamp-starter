package de.comsystoreply.spring.core.bootcamp.racingteam;

public class Driver {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private RacingTeam racingTeam;

    public Driver(long id, String firstName, String lastName, int age, RacingTeam racingTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.racingTeam = racingTeam;
    }
}

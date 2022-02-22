package de.comsystoreply.springtrainingdemo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Date birthday;
    @ManyToOne
    private RacingTeam racingTeam;

    public Driver() {

    }

    public Driver(String firstName) {
        this.firstName = firstName;
    }

    public Driver(String firstName, Date birthday) {
        this.firstName = firstName;
        this.birthday = birthday;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }

}

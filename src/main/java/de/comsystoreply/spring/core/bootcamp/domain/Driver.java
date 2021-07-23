package de.comsystoreply.spring.core.bootcamp.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne(optional = false)
    private Team team;

    public Long getId() {
        return id;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(firstName, driver.firstName) && Objects.equals(lastName, driver.lastName) && Objects.equals(team, driver.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, team);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", team=" + team +
                '}';
    }
}

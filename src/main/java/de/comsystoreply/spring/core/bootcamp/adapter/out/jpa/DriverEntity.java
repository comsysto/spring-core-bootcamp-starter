package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
class DriverEntity {

    @Id
    private String id;

    private String name;

    @ManyToOne
    private RacingTeamEntity team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RacingTeamEntity getTeam() {
        return team;
    }

    public void setTeam(RacingTeamEntity team) {
        this.team = team;
    }
}

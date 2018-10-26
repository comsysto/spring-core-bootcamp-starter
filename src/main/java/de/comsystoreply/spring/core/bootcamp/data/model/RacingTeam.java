package de.comsystoreply.spring.core.bootcamp.data.model;

import javax.persistence.*;

@Entity
@Table(name = "RACING_TEAM")
public class RacingTeam {

    @Id
    @SequenceGenerator(name = "racing_team_generator",
            sequenceName = "RACING_TEAM_SEQUENCE",
            allocationSize = 1)
    @GeneratedValue(generator = "racing_team_generator")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public RacingTeam(){

    }

    public RacingTeam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

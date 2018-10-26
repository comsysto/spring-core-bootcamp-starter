package de.comsystoreply.spring.core.bootcamp.web.model;

public class RacingTeamResource {

    private String name;

    public RacingTeamResource() {

    }

    public RacingTeamResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


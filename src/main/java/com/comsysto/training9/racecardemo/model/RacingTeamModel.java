package com.comsysto.training9.racecardemo.model;

public class RacingTeamModel {
    private long id;
    private String name;

    public RacingTeamModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

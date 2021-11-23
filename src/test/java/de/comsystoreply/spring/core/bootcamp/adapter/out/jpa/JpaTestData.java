package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import de.comsystoreply.spring.core.bootcamp.TestData;

import static de.comsystoreply.spring.core.bootcamp.TestData.aString;

public abstract class JpaTestData {

    private JpaTestData() {
    }

    public static RacingTeamEntity aRacingTeamEntity() {
        var entity = new RacingTeamEntity();
        entity.setId(aString());
        entity.setName(aString());

        return entity;
    }

    public static DriverEntity aDriverEntity() {
        var entity = new DriverEntity();
        entity.setId(aString());
        entity.setName(aString());

        return entity;
    }
}

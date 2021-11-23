package de.comsystoreply.spring.core.bootcamp;

import java.util.UUID;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.ImmutableDriver;
import de.comsystoreply.spring.core.bootcamp.domain.ImmutableRacingTeam;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

public abstract class TestData {

    private TestData() {
    }

    public static String aString() {
        return UUID.randomUUID().toString();
    }

    public static ImmutableRacingTeam aRacingTeam() {
        return ImmutableRacingTeam.builder()
                .id(Id.randomOf(RacingTeam.class))
                .name(aString())
                .build();
    }

    public static ImmutableDriver aDriver() {
        return ImmutableDriver.builder()
                .id(Id.randomOf(Driver.class))
                .name(aString())
                .build();
    }
}

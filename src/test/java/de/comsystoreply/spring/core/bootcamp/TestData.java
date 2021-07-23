package de.comsystoreply.spring.core.bootcamp;

import java.util.UUID;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

public class TestData {

    public static String aString() {
        return UUID.randomUUID().toString();
    }

    public static Team aTeam() {
        var team = new Team();
        team.setName(aString());

        return team;
    }
}

package de.comsystoreply.spring.core.bootcamp;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;

import java.util.*;

public class RacingService implements Racing {

    private Map<String, RacingTeam> racingTeams = new HashMap<>();

    @Override
    public RacingTeam createRacingTeam(String name) {
        if (getRacingTeamByName(name).isPresent()) {
            throw new IllegalArgumentException();
        }
        RacingTeam racingTeam = new RacingTeam(name);
        racingTeams.put(name, racingTeam);
        return racingTeam;
    }

    @Override
    public void deleteRacingTeamByName(String name) {
        racingTeams.remove(name);
    }

    @Override
    public RacingTeam modifyTeamByName(String oldName, String newName) {
        RacingTeam racingTeam = racingTeams.remove(oldName);
        if(racingTeam == null) throw new IllegalArgumentException();
        racingTeam.setName(newName);
        racingTeams.put(newName, racingTeam);
        return racingTeam;
    }

    @Override
    public Optional<RacingTeam> getRacingTeamByName(String name) {
        return Optional.ofNullable(racingTeams.get(name));
    }

    @Override
    public List<RacingTeam> getAllRacingTeams() {
        Collection<RacingTeam> values = racingTeams.values();
        return Collections.unmodifiableList(new ArrayList<>(values));
    }

    @Override
    public void deleteAllRacingTeams() {
        racingTeams.clear();
    }
}

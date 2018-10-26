package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.TeamAlreadyExistsException;
import de.comsystoreply.spring.core.bootcamp.data.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RacingService implements Racing {

    private Map<String, RacingTeam> racingTeams = new HashMap<>();

    private final RacingTeamRepository repository;

    @Autowired
    public RacingService(RacingTeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public RacingTeam createRacingTeam(String name) {
        if (getRacingTeamByName(name).isPresent()) {
            throw new TeamAlreadyExistsException();
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

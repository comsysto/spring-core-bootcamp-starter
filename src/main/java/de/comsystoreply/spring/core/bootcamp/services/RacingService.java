package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.TeamAlreadyExistsException;
import de.comsystoreply.spring.core.bootcamp.data.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacingService implements Racing {

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
        return repository.save(racingTeam);
    }

    @Override
    public void deleteRacingTeamByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public RacingTeam modifyTeamByName(String oldName, String newName) {
        RacingTeam racingTeam = repository.findByName(oldName);
        if(racingTeam == null) throw new IllegalArgumentException();
        racingTeam.setName(newName);
        return repository.save(racingTeam);
    }

    @Override
    public Optional<RacingTeam> getRacingTeamByName(String name) {
        return Optional.ofNullable(repository.findByName(name));
    }

    @Override
    public List<RacingTeam> getAllRacingTeams() {
        return repository.findAll();
    }

    @Override
    public void deleteAllRacingTeams() {
        repository.deleteAll();
    }
}

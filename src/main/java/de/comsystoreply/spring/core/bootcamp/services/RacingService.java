package de.comsystoreply.spring.core.bootcamp.services;

import de.comsystoreply.spring.core.bootcamp.TeamAlreadyExistsException;
import de.comsystoreply.spring.core.bootcamp.data.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.data.model.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.web.model.RacingTeamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RacingService implements Racing {

    private final RacingTeamRepository repository;

    @Autowired
    public RacingService(RacingTeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public RacingTeamResource createRacingTeam(String name) {
        if (getRacingTeamByName(name).isPresent()) {
            throw new TeamAlreadyExistsException();
        }
        RacingTeam racingTeam = new RacingTeam(name);
        return RacingTeamMapper.toResource(repository.save(racingTeam));
    }

    @Override
    public void deleteRacingTeamByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public RacingTeamResource modifyTeamByName(String oldName, String newName) {
        RacingTeam racingTeam = repository.findByName(oldName);
        if(racingTeam == null) throw new IllegalArgumentException();
        racingTeam.setName(newName);
        return RacingTeamMapper.toResource(repository.save(racingTeam));
    }

    @Override
    public Optional<RacingTeamResource> getRacingTeamByName(String name) {
        return Optional.ofNullable(RacingTeamMapper.toResource(repository.findByName(name)));
    }

    @Override
    public List<RacingTeamResource> getAllRacingTeams() {
        return repository.findAll().stream()
                .map(item -> RacingTeamMapper.toResource(item))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllRacingTeams() {
        repository.deleteAll();
    }
}

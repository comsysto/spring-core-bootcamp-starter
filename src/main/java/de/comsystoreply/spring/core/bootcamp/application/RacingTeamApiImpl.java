package de.comsystoreply.spring.core.bootcamp.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.comsystoreply.spring.core.bootcamp.adapter.out.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.ImmutableRacingTeam;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

@Component
public class RacingTeamApiImpl implements RacingTeamApi{

    private final RacingTeamRepository repository;

    @Autowired
    public RacingTeamApiImpl(RacingTeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public RacingTeam createNewRacingTeam(String name) {
        return ImmutableRacingTeam.builder()
                .id(Id.randomOf(RacingTeam.class))
                .name(name)
                .build();
    }

    @Override
    @Transactional
    public RacingTeam save(RacingTeam racingTeam) {
        return repository.save(racingTeam);
    }

    @Override
    public Optional<RacingTeam> findById(Id<RacingTeam> racingTeamId) {
        return repository.findById(racingTeamId);
    }
}

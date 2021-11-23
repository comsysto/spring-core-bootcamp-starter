package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.adapter.out.RacingTeamRepository;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

@Repository
class RacingTeamRepositoryImpl implements RacingTeamRepository {

    private final RacingTeamEntityJpaRepository entityRepository;
    private final Mapper<RacingTeam, RacingTeamEntity> racingTeamMapper;

    @Autowired
    public RacingTeamRepositoryImpl(
            RacingTeamEntityJpaRepository entityRepository,
            Mapper<RacingTeam, RacingTeamEntity> racingTeamMapper
    ) {
        this.entityRepository = entityRepository;
        this.racingTeamMapper = racingTeamMapper;
    }

    @Override
    public RacingTeam save(RacingTeam racingTeam) {
        var entity = racingTeamMapper.map(racingTeam);
        entityRepository.save(entity);

        return racingTeam;
    }

    @Override
    public Optional<RacingTeam> findById(Id<RacingTeam> racingTeamId) {
        return entityRepository.findById(racingTeamId.raw())
                .map(racingTeamMapper::reverse);
    }
}

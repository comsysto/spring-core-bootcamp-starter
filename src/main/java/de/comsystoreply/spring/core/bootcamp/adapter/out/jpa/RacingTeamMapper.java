package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.ImmutableRacingTeam;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

@Component
class RacingTeamMapper implements Mapper<RacingTeam, RacingTeamEntity> {

    private final Mapper<Driver, DriverEntity> driverMapper;

    @Autowired
    public RacingTeamMapper(Mapper<Driver, DriverEntity> driverMapper) {
        this.driverMapper = driverMapper;
    }

    public RacingTeamEntity map(RacingTeam racingTeam) {
        var entity = new RacingTeamEntity();
        entity.setId(racingTeam.id().raw());
        entity.setName(racingTeam.name());
        entity.setDrivers(
                driverMapper.mapAll(racingTeam.drivers())
        );

        return entity;
    }

    @Override
    public RacingTeam reverse(RacingTeamEntity original) {
        return ImmutableRacingTeam.builder()
                .id(Id.of(RacingTeam.class, original.getId()))
                .name(original.getName())
                .addAllDrivers(
                        driverMapper.reverseAll(original.getDrivers())
                )
                .build();
    }
}

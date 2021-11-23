package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

@Component
class RacingTeamMapper implements Mapper<RacingTeam, RacingTeamEntity> {

    private final Mapper<Driver, DriverEntity> driverMapper;

    @Autowired
    public RacingTeamMapper(Mapper<Driver, DriverEntity> driverMapper) {
        this.driverMapper = driverMapper;
    }

    public RacingTeamEntity map(RacingTeam racingTeam) {
        var drivers = driverMapper.mapAll(racingTeam.drivers());

        var entity = new RacingTeamEntity();
        entity.setId(racingTeam.id().getValue());
        entity.setName(racingTeam.name());
        entity.setDrivers(drivers);

        return entity;
    }
}

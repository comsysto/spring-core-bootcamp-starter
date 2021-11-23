package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import java.util.Set;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

import static de.comsystoreply.spring.core.bootcamp.TestData.aDriver;
import static de.comsystoreply.spring.core.bootcamp.TestData.aRacingTeam;
import static de.comsystoreply.spring.core.bootcamp.TestData.aString;
import static de.comsystoreply.spring.core.bootcamp.adapter.out.jpa.JpaTestData.aDriverEntity;
import static de.comsystoreply.spring.core.bootcamp.adapter.out.jpa.JpaTestData.aRacingTeamEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class RacingTeamMapperTest {

    @Mock
    private Mapper<Driver, DriverEntity> driverMapper;

    @InjectMocks
    private RacingTeamMapper racingTeamMapper;

    @Nested
    class MapToEntity {

        @Test
        void idIsMapped() {
            var id = Id.randomOf(RacingTeam.class);
            var team = aRacingTeam()
                    .withId(id);

            var result = racingTeamMapper.map(team);

            assertEquals(id.raw(), result.getId());
        }

        @Test
        void nameIsMapped() {
            var name = aString();
            var team = aRacingTeam()
                    .withName(name);

            var result = racingTeamMapper.map(team);

            assertEquals(name, result.getName());
        }

        @Test
        void driverAreMapped() {
            var driverA = aDriver();
            var driverB = aDriver();
            var team = aRacingTeam()
                    .withDrivers(driverA, driverB);

            var driverEntityA = aDriverEntity();
            var driverEntityB = aDriverEntity();
            doReturn(Set.of(driverEntityA, driverEntityB))
                    .when(driverMapper).mapAll(Set.of(driverA, driverB));

            var result = racingTeamMapper.map(team);

            assertEquals(Set.of(driverEntityA, driverEntityB), result.getDrivers());
        }
    }

    @Nested
    class MapFromEntity {

        @Test
        void idIsMapped() {
            var id = Id.randomOf(RacingTeam.class);
            var teamEntity = aRacingTeamEntity();
            teamEntity.setId(id.raw());

            var result = racingTeamMapper.reverse(teamEntity);

            assertEquals(id, result.id());
        }

        @Test
        void nameIsMapped() {
            var name = aString();
            var teamEntity = aRacingTeamEntity();
            teamEntity.setName(name);

            var result = racingTeamMapper.reverse(teamEntity);

            assertEquals(name, result.name());
        }

        @Test
        void driverAreMapped() {
            var driverEntityA = aDriverEntity();
            var driverEntityB = aDriverEntity();
            var teamEntity = aRacingTeamEntity();
            teamEntity.setDrivers(Set.of(driverEntityA, driverEntityB));

            var driverA = aDriver();
            var driverB = aDriver();
            doReturn(Set.of(driverA, driverB))
                    .when(driverMapper).reverseAll(Set.of(driverEntityA, driverEntityB));

            var result = racingTeamMapper.reverse(teamEntity);

            assertEquals(Set.of(driverA, driverB), result.drivers());
        }
    }
}

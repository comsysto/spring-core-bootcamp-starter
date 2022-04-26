package com.comsysto.springtraining.formula1manager;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import com.comsysto.springtraining.formula1manager.repository.DriverRepository;
import com.comsysto.springtraining.formula1manager.repository.RacingTeamRepository;
import com.comsysto.springtraining.formula1manager.service.RacingTeamService;
import com.comsysto.springtraining.formula1manager.service.RacingTeamServiceIF;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataInitializerConfiguration {

    @Bean
    public CommandLineRunner setStartupData(RacingTeamRepository racingTeamRepository, DriverRepository driverRepository) {
        return args -> {
            RacingTeam team1 = new RacingTeam(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"), "Team 1");
            var resultingTeam = racingTeamRepository.save(team1);

            Driver driver1 = new Driver(UUID.fromString("2b674d9d-6d41-418f-ac49-560de47bd81d"),
                    "first",
                    "last",
                    50,
                ZonedDateTime.of(1990, 2, 1, 0, 0, 0, 0, ZoneId.of("America/Los_Angeles")), resultingTeam);
            driverRepository.save(driver1);
        };
    }

    @Bean
    @Primary
    public RacingTeamServiceIF racingTeamServiceProxy(RacingTeamService racingTeamService) {
            return (RacingTeamServiceIF) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {RacingTeamServiceIF.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(racingTeamService, args);
                    }
        });
    }
}

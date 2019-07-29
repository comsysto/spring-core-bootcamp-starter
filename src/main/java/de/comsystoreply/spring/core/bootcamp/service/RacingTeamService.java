package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.repo.RacingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacingTeamService {
    @Autowired
    private RacingTeamRepository racingTeamRepo;

    public RacingTeam findById(long id) {
        Optional<RacingTeam> racingTeam = racingTeamRepo.findById(id);
        return racingTeam.orElse(null);
    }

    public List< RacingTeam> findAll() {
        List<RacingTeam> allList = racingTeamRepo.findAll();
        return allList;
    }


    public RacingTeam save( RacingTeam racingTeam ) {
        RacingTeam savedRacingTeam = racingTeamRepo.save(racingTeam);
        return savedRacingTeam;
    }

    public void delete( long id) {
        racingTeamRepo.deleteById(id);
    }

}

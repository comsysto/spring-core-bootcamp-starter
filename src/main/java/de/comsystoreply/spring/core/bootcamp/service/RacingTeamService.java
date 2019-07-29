package de.comsystoreply.spring.core.bootcamp.service;

import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;
import de.comsystoreply.spring.core.bootcamp.repo.RacingTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RacingTeamService {
    @Autowired
    private RacingTeamRepository racingTeamRepo;

    @Transactional
    public RacingTeam findById(long id) {
        Optional<RacingTeam> racingTeam = racingTeamRepo.findById(id);
        racingTeam.ifPresent(this::touchDriversAndRaceCars);
        return racingTeam.orElse(null);
    }

    @Transactional
    public List< RacingTeam> findAll() {
        List<RacingTeam> allList = racingTeamRepo.findAll();
        allList.forEach(this::touchDriversAndRaceCars);
        return allList;
    }

    public RacingTeam save( RacingTeam racingTeam ) {
        RacingTeam savedRacingTeam = racingTeamRepo.save(racingTeam);
        return savedRacingTeam;
    }

    public void delete( long id) {
        racingTeamRepo.deleteById(id);
    }

    private void touchDriversAndRaceCars(RacingTeam racingTeam) {
        racingTeam.getDrivers().size();
        racingTeam.getRaceCars().size();
    }

}

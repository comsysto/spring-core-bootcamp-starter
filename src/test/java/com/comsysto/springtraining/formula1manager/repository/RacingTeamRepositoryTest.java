package com.comsysto.springtraining.formula1manager.repository;

import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class RacingTeamRepositoryTest {
    @Autowired
    RacingTeamRepository racingTeamRepository;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Test
    public void saveTeamShouldWork() {
        RacingTeam racingTeam1 = new RacingTeam(null, "Team 1");

        racingTeamRepository.save(racingTeam1);

        assertThat(racingTeamRepository.count()).isEqualTo(1L);
    }

    @Test
    public void saveTeamShouldWork2() {
        transactionTemplate.execute(x -> {
            RacingTeam racingTeam1 = new RacingTeam(null, "Team 1");

            racingTeamRepository.save(racingTeam1);

            assertThat(racingTeamRepository.count()).isEqualTo(1L);
            return null;
        });
    }
}

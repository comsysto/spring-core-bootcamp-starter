package de.comsystoreply.springtrainingdemo;

import de.comsystoreply.springtrainingdemo.service.RacingTeamService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RacingTeamApplicationTests {

	@Test
	void createTeam() {
		RacingTeamService racingTeamService = new RacingTeamService();
		Assert.notNull(racingTeamService.createRacingTeam("someRacingTeam"));

	}


}

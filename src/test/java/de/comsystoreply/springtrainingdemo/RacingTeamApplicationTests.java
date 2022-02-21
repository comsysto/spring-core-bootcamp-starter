package de.comsystoreply.springtrainingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RacingTeamApplicationTests {

	@Test
	void createTeam() {
		RacingTeamService racingTeamService = new RacingTeamService();
		racingTeamService.createTeam('Test-Team');
		Assert.notNull(racingTeamService.createTeam('Test-Team'), null);
	}


}

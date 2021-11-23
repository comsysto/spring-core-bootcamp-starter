package de.comsystoreply.spring.core.bootcamp.adapter.in;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import de.comsystoreply.spring.core.bootcamp.application.RacingTeamApi;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping(path = "/api/racing-team", produces = APPLICATION_JSON_VALUE)
public class RacingTeamController {

    private final RacingTeamApi api;

    @Autowired
    public RacingTeamController(RacingTeamApi api) {
        this.api = api;
    }

    @PostMapping
    public ResponseEntity<RacingTeamResponse> createRacingTeam(
            @RequestBody CreateRacingTeamRequest request,
            UriComponentsBuilder uriBuilder
    ) {
        var createdTeam = api.save(
                api.createNewRacingTeam(request.name())
        );

        var responseBody = new RacingTeamResponse(
                createdTeam.id().getValue(),
                createdTeam.name()
        );
        var location = uriBuilder.path("/api/racing-team/{id}")
                .buildAndExpand(Map.of("id", createdTeam.id().getValue()));

        return created(location.toUri())
                .body(responseBody);
    }

    record CreateRacingTeamRequest(
            String name
    ) {
    }

    record RacingTeamResponse(
            String id,
            String name
    ) {
    }
}

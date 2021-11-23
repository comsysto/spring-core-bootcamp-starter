package de.comsystoreply.spring.core.bootcamp.adapter.in;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import de.comsystoreply.spring.core.bootcamp.application.RacingTeamApi;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.RacingTeam;

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

        var location = uriBuilder.path("/api/racing-team/{id}")
                .buildAndExpand(Map.of("id", createdTeam.id().raw()));

        return created(location.toUri())
                .body(RacingTeamResponse.from(createdTeam));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RacingTeamResponse> findById(@PathVariable("id") String id) {
        return api.findById(Id.of(RacingTeam.class, id))
                .map(RacingTeamResponse::from)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private record CreateRacingTeamRequest(
            String name
    ) {
    }

    private record RacingTeamResponse(
            String id,
            String name
    ) {

        static RacingTeamResponse from(RacingTeam original) {
            return new RacingTeamResponse(
                    original.id().raw(),
                    original.name()
            );
        }
    }
}

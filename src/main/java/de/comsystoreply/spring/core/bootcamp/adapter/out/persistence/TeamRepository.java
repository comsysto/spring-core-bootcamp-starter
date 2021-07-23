package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    @Transactional(readOnly = true)
    Optional<Team> findByName(String name);
}

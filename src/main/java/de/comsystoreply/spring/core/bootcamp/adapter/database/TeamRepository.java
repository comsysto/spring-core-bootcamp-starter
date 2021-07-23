package de.comsystoreply.spring.core.bootcamp.adapter.database;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    /*
     * At the moment this interface is redundant. For practical use it is very likely that most, if not all, your
     * repositories also implement custom queries, that are not shared with a base repository.
     */
}

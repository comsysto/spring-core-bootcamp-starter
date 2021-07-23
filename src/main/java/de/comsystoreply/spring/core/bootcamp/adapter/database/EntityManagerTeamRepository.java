package de.comsystoreply.spring.core.bootcamp.adapter.database;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

@Repository
class EntityManagerTeamRepository implements TeamRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Team create(Team team) {
        return entityManager.merge(team);
    }

    @Override
    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(
                entityManager.find(Team.class, id)
        );
    }

    @Override
    public void delete(Team item) {
        entityManager.remove(item);
    }
}

package de.comsystoreply.spring.core.bootcamp.adapter.database;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

/**
 * Implements a {@link TeamRepository} by directly interacting with the {@link EntityManager}.
 */
@Repository
class EntityManagerTeamRepository implements TeamRepository {

    /*
     * Note that this class is package private. It should never be used outside this package. All classes requiring
     * interaction with the DB should do so using the interface instead.
     */

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Team create(Team team) {
        return entityManager.merge(team);
    }

    @Override
    public Team update(Team team) {
        return entityManager.merge(team);
    }

    @Override
    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(
                entityManager.find(Team.class, id)
        );
    }

    @Override
    public List<Team> findAll() {
        return entityManager.createQuery("SELECT t FROM Team t", Team.class)
                .getResultList();
    }

    @Override
    public void delete(Team item) {
        entityManager.remove(item);
    }
}

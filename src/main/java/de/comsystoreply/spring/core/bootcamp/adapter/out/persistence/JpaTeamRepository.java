package de.comsystoreply.spring.core.bootcamp.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.comsystoreply.spring.core.bootcamp.domain.Team;

/**
 * Implements a {@link TeamRepository} by directly interacting with the {@link EntityManager}.
 */
@Repository
class JpaTeamRepository extends JpaCrudRepositroy<Team, Long> implements TeamRepository {

    /*
     * Note that this class is package private. It should never be used outside this package. All classes requiring
     * interaction with the DB should do so using the interface instead.
     */

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JpaTeamRepository() {
        super(Team.class);
    }

    @Override
    public List<Team> findAll() {
        return entityManager.createQuery("SELECT t FROM Team t", Team.class)
                .getResultList();
    }

    @Override
    public Optional<Team> findByName(String name) {
        return Optional.ofNullable(
                entityManager.createQuery("SELECT t FROM Team t WHERE t.name = :name", Team.class)
                        .setParameter("name", name)
                        .getSingleResult()
        );
    }
}

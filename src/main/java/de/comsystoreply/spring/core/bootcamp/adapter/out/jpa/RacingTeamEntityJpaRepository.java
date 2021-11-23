package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RacingTeamEntityJpaRepository extends JpaRepository<RacingTeamEntity, String> {

}

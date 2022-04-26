package com.comsysto.springtraining.formula1manager.repository;

import com.comsysto.springtraining.formula1manager.model.Driver;
import com.comsysto.springtraining.formula1manager.model.RacingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface DriverRepository extends CrudRepository<Driver, UUID> {
    List<Driver> findAllByRacingTeamId(UUID id);

    @Override
    List<Driver> findAll();
}
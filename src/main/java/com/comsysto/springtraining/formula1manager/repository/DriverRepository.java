package com.comsysto.springtraining.formula1manager.repository;

import com.comsysto.springtraining.formula1manager.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DriverRepository extends CrudRepository<Driver, UUID> {
}
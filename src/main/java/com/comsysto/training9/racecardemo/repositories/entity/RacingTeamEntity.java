package com.comsysto.training9.racecardemo.repositories.entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class RacingTeamEntity {
    @Id
    @GeneratedValue
    Long id;
    String name;
}

package com.comsysto.training9.racecardemo.model;

import javax.persistence.Entity;
import lombok.Value;

@Value
@Entity
public class RacingTeamModel {

    Long id;
    String name;
}

package com.comsysto.springtraining.formula1manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // this is just for hibernate
public class Driver {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne
    private RacingTeam racingTeam;
}

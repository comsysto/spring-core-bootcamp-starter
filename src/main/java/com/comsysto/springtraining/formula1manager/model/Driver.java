package com.comsysto.springtraining.formula1manager.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(timezone = "America/Los_Angeles")
    private Instant birthday;

    @ManyToOne
    private RacingTeam racingTeam;
}

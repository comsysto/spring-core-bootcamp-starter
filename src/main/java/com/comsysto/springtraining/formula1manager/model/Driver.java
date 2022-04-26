package com.comsysto.springtraining.formula1manager.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // this is just for hibernate
public class Driver {
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @Min(18)
    @Max(99)
    private int age;

    private ZonedDateTime birthday;

    @ManyToOne
    private RacingTeam racingTeam;
}

package com.comsysto.springtraining.formula1manager.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // this is just for hibernate
@Entity
public class RacingTeam {
    @Id
    @GeneratedValue
    private UUID id;
    @NotBlank
    private String name;
}

package com.comsysto.springtraining.formula1manager.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RacingTeam {
    private UUID id;
    private String name;
}

package com.comsysto.springtraining.formula1manager.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Data
@AllArgsConstructor
public class RacingTeam {
    @Generated
    private UUID id;
    private String name;
}

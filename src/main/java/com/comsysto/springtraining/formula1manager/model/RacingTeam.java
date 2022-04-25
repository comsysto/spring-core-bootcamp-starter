package com.comsysto.springtraining.formula1manager.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // this is just for hibernate
@Entity
public class RacingTeam {
    @Id
    private UUID id;
    private String name;

    @OneToMany
    private List<Driver> drivers;
}

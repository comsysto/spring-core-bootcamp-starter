package com.comsysto.springtraining.formula1manager.model;

import javax.persistence.Id;
import java.util.UUID;

public class Driver {
    @Id
    private UUID id;
    private String name;
}

package de.comsystoreply.spring.core.bootcamp.domain;

import java.util.Set;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;

@Immutable
@Style(jdkOnly = true, strictBuilder = true, stagedBuilder = true)
public interface RacingTeam {

    Id<RacingTeam> id();

    String name();

    Set<Driver> drivers();
}

package de.comsystoreply.spring.core.bootcamp.domain;

import org.immutables.value.Value.Immutable;
import org.immutables.value.Value.Style;

@Immutable
@Style(jdkOnly = true, strictBuilder = true, stagedBuilder = true)
public interface Driver {

    Id<Driver> id();

    String name();
}

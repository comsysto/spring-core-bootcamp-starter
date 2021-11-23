package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public interface Mapper<U, T> {

    T map(U original);

    default Set<T> mapAll(Set<U> original) {
        return original.stream()
                .map(this::map)
                .collect(toSet());
    }
}

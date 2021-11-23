package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public interface Mapper<U, T> {

    T map(U original);

    U reverse(T original);

    default Set<T> mapAll(Set<U> original) {
        return original.stream()
                .map(this::map)
                .collect(toSet());
    }

    default Set<U> reverseAll(Set<T> original) {
        return original.stream()
                .map(this::reverse)
                .collect(toSet());
    }
}

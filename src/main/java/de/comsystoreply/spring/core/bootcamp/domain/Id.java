package de.comsystoreply.spring.core.bootcamp.domain;

import java.util.Objects;
import java.util.UUID;

public final class Id<T> {

    private final String value;

    private final Class<T> targetType;

    private Id(String value, Class<T> targetType) {
        this.value = value;
        this.targetType = targetType;
    }

    public static <T> Id<T> of(Class<T> targetType, String rawValue) {
        return new Id<>(rawValue, targetType);
    }

    public static <T> Id<T> randomOf(Class<T> targetType) {
        return Id.of(targetType, UUID.randomUUID().toString());
    }

    public String raw() {
        return value;
    }

    public Class<T> getTargetType() {
        return targetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id)) return false;
        Id<?> id = (Id<?>) o;
        return Objects.equals(value, id.value) && Objects.equals(targetType, id.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, targetType);
    }
}

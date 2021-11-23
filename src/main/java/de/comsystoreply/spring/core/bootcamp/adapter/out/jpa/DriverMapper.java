package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.springframework.stereotype.Component;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.Id;
import de.comsystoreply.spring.core.bootcamp.domain.ImmutableDriver;

@Component
class DriverMapper implements Mapper<Driver, DriverEntity> {

    public DriverEntity map(Driver driver) {
        var entity = new DriverEntity();
        entity.setId(driver.id().raw());
        entity.setName(driver.name());

        return entity;
    }

    @Override
    public Driver reverse(DriverEntity original) {
        return ImmutableDriver.builder()
                .id(Id.of(Driver.class, original.getId()))
                .name(original.getName())
                .build();
    }
}

package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.springframework.stereotype.Component;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;

@Component
class DriverMapper implements Mapper<Driver, DriverEntity> {

    public DriverEntity map(Driver driver) {
        var entity = new DriverEntity();
        entity.setId(driver.id().getValue());
        entity.setName(driver.name());

        return entity;
    }
}

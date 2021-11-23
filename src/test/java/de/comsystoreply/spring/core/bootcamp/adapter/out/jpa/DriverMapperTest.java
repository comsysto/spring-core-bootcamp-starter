package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.comsystoreply.spring.core.bootcamp.domain.Driver;
import de.comsystoreply.spring.core.bootcamp.domain.Id;

import static de.comsystoreply.spring.core.bootcamp.TestData.aDriver;
import static de.comsystoreply.spring.core.bootcamp.TestData.aString;
import static de.comsystoreply.spring.core.bootcamp.adapter.out.jpa.JpaTestData.aDriverEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverMapperTest {

    private final DriverMapper mapper = new DriverMapper();

    @Nested
    class MapToEntity {

        @Test
        void idIsMapped() {
            var id = Id.randomOf(Driver.class);
            var driver = aDriver()
                    .withId(id);

            var result = mapper.map(driver);

            assertEquals(id.raw(), result.getId());
        }

        @Test
        void nameIsMapped() {
            var name = aString();
            var driver = aDriver()
                    .withName(name);

            var result = mapper.map(driver);

            assertEquals(name, result.getName());
        }
    }

    @Nested
    class MapFromEntity {

        @Test
        void idIsMapped() {
            var id = Id.randomOf(Driver.class);
            var driverEntity = aDriverEntity();
            driverEntity.setId(id.raw());

            var result = mapper.reverse(driverEntity);

            assertEquals(id, result.id());
        }

        @Test
        void nameIsMapped() {
            var name = aString();
            var driverEntity = aDriverEntity();
            driverEntity.setName(name);

            var result = mapper.reverse(driverEntity);

            assertEquals(name, result.name());
        }
    }
}

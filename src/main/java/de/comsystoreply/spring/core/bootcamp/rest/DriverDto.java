package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.Driver;

import java.time.LocalDate;

public class DriverDto {
    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;

    public DriverDto() {}

    public DriverDto(Long id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static DriverDto toDto(Driver driver) {
        return new DriverDto(
                driver.getId(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.getDateOfBirth()
        );
    }

    public static Driver fromDto(DriverDto dto) {
        return new Driver(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getDateOfBirth(),
                null // TODO: getTeam
        );
    }
}

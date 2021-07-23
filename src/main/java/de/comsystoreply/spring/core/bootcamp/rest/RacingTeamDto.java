package de.comsystoreply.spring.core.bootcamp.rest;

import de.comsystoreply.spring.core.bootcamp.model.RacingTeam;

import java.util.stream.Collectors;
import java.util.List;

public class RacingTeamDto {

    Long id;
    String name;
    List<DriverDto> drivers;    
    
    public RacingTeamDto() {}
    
    public RacingTeamDto(Long id, String name, List<DriverDto> drivers) {
        this.id = id;
        this.name = name;
        this.drivers = drivers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DriverDto> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverDto> drivers) {
        this.drivers = drivers;
    }

    public static RacingTeamDto toDto(RacingTeam racingTeam) {
        return new RacingTeamDto(
                racingTeam.getId(),
                racingTeam.getName(),
                racingTeam.getDrivers().stream()
                    .map(DriverDto::toDto)
                    .collect(Collectors.toList())
        );
    }

    public static RacingTeam fromDto(RacingTeamDto dto) {
        return new RacingTeam(
                dto.getId(),
                dto.getName(),
                dto.getDrivers().stream()
                    .map(DriverDto::fromDto)
                    .collect(Collectors.toList())
        );
    }
}

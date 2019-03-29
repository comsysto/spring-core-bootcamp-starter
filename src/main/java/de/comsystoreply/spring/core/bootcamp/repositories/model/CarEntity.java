package de.comsystoreply.spring.core.bootcamp.repositories.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CarEntity {

    @GeneratedValue(generator = "car_id_gen")
    @SequenceGenerator(name = "car_id_gen", sequenceName = "car_id_gen", allocationSize = 1)
    @Id
    private Long id;
    private String name;

    public CarEntity() {
    }

    public CarEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public static CarEntity fromDto(CarDto carDto) {
        return new CarEntity(carDto.getId(), carDto.getName());
    }
}
package de.comsystoreply.spring.core.bootcamp.repositories.model;

public class CarDto {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CarDto fromEntity(CarEntity entity) {
        return new CarDto(entity.getId(), entity.getName());
    }
}

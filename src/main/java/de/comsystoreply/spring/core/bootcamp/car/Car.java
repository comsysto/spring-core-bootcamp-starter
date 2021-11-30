package de.comsystoreply.spring.core.bootcamp.car;

import de.comsystoreply.spring.core.bootcamp.repository.CarEntity;

import java.util.Objects;

public class Car {

    //todo: not null, discuss uuid
    private Long id;
    private String title;
    private int horsePower;
    private float weightInKilo;

    public Car(Long id, String title, int horsePower, float weightInKilo) {
        this.id = id;
        this.title = title;
        this.horsePower = horsePower;
        this.weightInKilo = weightInKilo;
    }

    public Car() {}

    //needs refactoring
    public Car(CarEntity carEntity) {
        this.id = carEntity.getId();
        this.title = carEntity.getTitle();
        this.horsePower = carEntity.getHorsePower();
        this.weightInKilo = carEntity.getWeightInKilo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public float getWeightInKilo() {
        return weightInKilo;
    }

    public void setWeightInKilo(float weightInKilo) {
        this.weightInKilo = weightInKilo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", horsePower=" + horsePower +
                ", weightInKilo=" + weightInKilo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower && Float.compare(car.weightInKilo, weightInKilo) == 0 && Objects.equals(id, car.id) && Objects.equals(title, car.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, horsePower, weightInKilo);
    }
}
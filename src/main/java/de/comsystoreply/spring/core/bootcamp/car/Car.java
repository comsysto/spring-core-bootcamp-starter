package de.comsystoreply.spring.core.bootcamp.car;

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
}
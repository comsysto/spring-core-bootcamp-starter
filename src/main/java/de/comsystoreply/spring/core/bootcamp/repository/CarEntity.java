package de.comsystoreply.spring.core.bootcamp.repository;


import javax.persistence.*;

@Entity
@Table(name="CAR")
public class CarEntity {

    @Id
    @SequenceGenerator(name = "car_generator",
            sequenceName = "CAR_SEQUENCE",
            allocationSize = 1)
    @GeneratedValue(generator = "car_generator")
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Column(name = "HORSE_POWER")
    private int horsePower;

    @Column(name = "WEIGHT_IN_KILO")
    private float weightInKilo;

    public CarEntity(Long id, String title, int horsePower, float weightInKilo) {
        this.id = id;
        this.title = title;
        this.horsePower = horsePower;
        this.weightInKilo = weightInKilo;
    }

    public CarEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public float getWeightInKilo() {
        return weightInKilo;
    }

    public void setId(Long id) {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setWeightInKilo(float weightInKilo) {
        this.weightInKilo = weightInKilo;
    }
}

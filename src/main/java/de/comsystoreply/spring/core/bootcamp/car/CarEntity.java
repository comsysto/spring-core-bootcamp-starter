package de.comsystoreply.spring.core.bootcamp.car;


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
}

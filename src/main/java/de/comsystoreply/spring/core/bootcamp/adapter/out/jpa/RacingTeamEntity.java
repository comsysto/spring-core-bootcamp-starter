package de.comsystoreply.spring.core.bootcamp.adapter.out.jpa;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "racing_team")
class RacingTeamEntity {

    @Id
    private String id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "team", cascade = ALL)
    private Set<DriverEntity> drivers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DriverEntity> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<DriverEntity> drivers) {
        this.drivers = drivers;
    }
}

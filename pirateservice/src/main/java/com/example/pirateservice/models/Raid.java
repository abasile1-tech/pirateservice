package com.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "raids")
public class Raid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "location")
    private String location;
    @Column(name = "loot")
    private int loot;
    @ManyToMany
    @JoinTable(
            name = "pirate_raids",
            joinColumns = {
                    @JoinColumn(
                            name = "raid_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "pirate_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    @JsonIgnoreProperties({"pirates"})
    private List<Pirate> pirates;

    public Raid(String location, int loot) {
        this.location = location;
        this.loot = loot;
    }

    public Raid() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }
}

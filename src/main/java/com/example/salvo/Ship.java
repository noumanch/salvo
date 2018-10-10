package com.example.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Native;
import java.util.List;
import java.util.Set;

@Entity
public class Ship {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @NotNull
    public String ship;

    @ManyToOne(fetch = FetchType.EAGER)
    private GamePlayer gamePlayer;

    @ElementCollection
    public List<String> locations;

    public Ship(@NotNull String ship, List<String> locations) {
        this.ship = ship;
        this.locations = locations;
    }

    @NotNull
    public String getShip() {
        return ship;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Ship() {
    }

    public void setShip(@NotNull String ship) {
        this.ship = ship;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }
}

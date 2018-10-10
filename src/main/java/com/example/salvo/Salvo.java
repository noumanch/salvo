package com.example.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Salvo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private long Id;

    private double turn;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private GamePlayer gamePlayer;



    @ElementCollection
    public List<String> locations;


    public Salvo(double turn, List<String> locations, GamePlayer gamePlayer) {
        this.turn = turn;
        this.locations = locations;
        this.gamePlayer = gamePlayer;
    }

    public Salvo() {
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public long getId() { return Id;
    }

    public double getTurn() { return turn;
    }


    public List<String> getLocations() { return locations;
    }

    public void setLocations(List<String> locations) { this.locations = locations;
    }
}

package com.example.salvo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long id;

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    private Date createdData;

    public Game() {
        this.createdData = new Date();
    }

    public Date getCreatedData() {
        return createdData;
    }

    public void setCreatedData(Date createdData) {
        this.createdData = createdData;
    }

    public Long getId() {
        return id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public Map<String, Object> getIDandDate(){
        Map<String, Object> dto = new HashMap<String, Object>();
        dto.put("id", this.getId());
        dto.put("Date", this.getCreatedData());
        dto.put("Players", createListFromGamePlayerSet(gamePlayers));
     return dto;
    }

    public List<Object> createListFromGamePlayerSet(Set<GamePlayer> gps){
        return gps.stream().map(gp -> returnInfoAboutOnePlayers(gp)).collect(Collectors.toList());
    }

    public Map<String, Object> returnInfoAboutOnePlayers(GamePlayer gp){
        Map<String, Object> dto3 = new HashMap<String, Object>();
        dto3.put("id", gp.getPlayer().getId());
        dto3.put("email", gp.getPlayer().getName());
        return dto3;
    }
}

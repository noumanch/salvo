package com.example.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    public Date playDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Game_id")
    public Game game;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Player_id")
    public Player player;

    @OneToMany(mappedBy="gamePlayer", fetch=FetchType.EAGER)
    private Set<Ship> ships = new HashSet<>();

    @OneToMany(mappedBy="gamePlayer", fetch=FetchType.EAGER)
    private Set<Salvo> salvo = new HashSet<>();

    public GamePlayer() {
    }

    public void addships(Ship ship){
        ship.setGamePlayer(this);
        ships.add(ship);

    }

    public GamePlayer(Set<Salvo> salvo) {
        this.salvo = salvo;
    }
    public Set<Salvo> getSalvo(){return salvo;}

    public Set<Ship> getShips() {
        return ships;
    }

    public GamePlayer(Game game, Player player) {

        this.playDate = new Date();
        this.game = game;
        this.player = player;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

/*    public Map<String, Object> getNameAndData(){
        Map<String,Object> dto1 = new HashMap<String, Object>();
        dto1.put("GamePlayerid", this.getId());
        dto1.put("Player",  getAllPlayer(this));
        return dto1;
    }

    public Map<String, Object> getAllPlayer(GamePlayer gamePlayer){
        Map<String, Object> dto2 = new HashMap<String, Object>();
        dto2.put("Player1", this.getPlayer());
        GamePlayer opponentGP = getOpponent(gamePlayer);
        if(opponentGP != null){
            dto2.put("Player2", opponentGP.getPlayer());
        }
        return dto2;
    }

    public GamePlayer getOpponent(GamePlayer gamePlayer){
       return gamePlayer.getGame().gamePlayers.stream().filter(gp -> !gp.equals(gamePlayer)).findFirst().orElse(null);
    }*/
}
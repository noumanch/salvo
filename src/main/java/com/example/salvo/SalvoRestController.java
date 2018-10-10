package com.example.salvo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoRestController {

    @Autowired
    private GameRepository repo;

    @Autowired
    private GamePlayerRepository repository;



    @RequestMapping("/createdData")
    public List<Object> getAll() {
        return repo.findAll().stream()
                .map(game -> getGameInfo(game))
                .collect(toList());

    }

    @RequestMapping(value = "/game_view/{nn}", method= RequestMethod.GET)
    public Map<String, Object> getOrder(@PathVariable Long nn) {

        GamePlayer selectedGP = repository.findOne(nn);

        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("Id", selectedGP.getGame().getId());
        dto.put("Date",selectedGP.getGame().getCreatedData());
        dto.put("GamePlayers", selectedGP.getGame().getGamePlayers().stream()
                .map(gamePlayer -> getGamePlayerinfo(gamePlayer)).collect(toList()));

        dto.put("Ships", selectedGP.getShips());
        dto.put("Salvo", selectedGP.getSalvo());



        return dto;
    }

    public Map<String, Object> getGamePlayerinfo(GamePlayer gamePlayer){
        Map<String, Object> dto =  new LinkedHashMap<String, Object>();
        dto.put("Id", gamePlayer.getId());
        dto.put("Player", gamePlayer.getPlayer().getName());

        return dto;
    }



    public Map<String, Object> getGameInfo(Game game) {
        Map<String, Object> dto = new HashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("Date", game.getCreatedData());
        dto.put("gamePlayers", game.getGamePlayers().stream()
                    .map(gamePlayer -> getGamePlayerInfo(gamePlayer))
                    .collect(toList()));
        return dto;
    }

    public Map<String, Object> getGamePlayerInfo(GamePlayer gamePlayer) {
        Map<String, Object> dto = new HashMap<String, Object>();
        dto.put("id", gamePlayer.getId());
        dto.put("date",gamePlayer.getPlayDate());
        dto.put("player", getPlayerInfo(gamePlayer.getPlayer()));
        dto.put("ships", gamePlayer.getShips());
        return dto;
    }

    public Map<String, Object> getPlayerInfo(Player player) {
        Map<String, Object> dto = new HashMap<String, Object>();
        dto.put("id", player.getId());
        dto.put("name", player.getName());
        return dto;
    }


}







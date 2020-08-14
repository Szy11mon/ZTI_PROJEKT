package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Player;
import com.biernacki.SpringProject.model.PlayerNice;
import com.biernacki.SpringProject.service.PlayerService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/player")
@RestController
@CrossOrigin(origins = "https://neo4j-project.herokuapp.com")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void addPlayerNice (@Valid @NonNull @RequestBody PlayerNice player){
        this.playerService.addPlayerNice(player);
    }

    @GetMapping
    public List<PlayerNice> getAllPlayerNice(){
        return playerService.getAllPlayerNice();
    }

    @GetMapping(path = "/standard")
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayer();
    }

    @GetMapping(path = "{id}")
    public List<Player> getPlayerById(@PathVariable("id") int id){
        return playerService.getPlayerById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getPlayerLoginById(@PathVariable("id") int id){
        return playerService.getPlayerLoginById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removePlayerById(@PathVariable("id") int id){
        playerService.removePlayerById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removePlayerByName(@PathVariable("name") String name){
        playerService.removePlayerByName(name);
    }
}

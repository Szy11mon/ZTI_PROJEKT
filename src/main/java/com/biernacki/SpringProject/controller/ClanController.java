package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Clan;
import com.biernacki.SpringProject.service.ClanService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/clan")
@RestController
@CrossOrigin(origins = "https://neo4j-project.herokuapp.com/")
public class ClanController {

    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    @PostMapping
    public void addClan (@Valid @NonNull @RequestBody Clan clan){
        this.clanService.addClan(clan);
    }

    @GetMapping
    public List<Clan> getAllClan(){
        return clanService.getAllClan();
    }

    @GetMapping(path = "{id}")
    public List<Clan> getClanById(@PathVariable("id") int id){
        return clanService.getClanById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getClanNameById(@PathVariable("id") int id){
        return clanService.getClanNameById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removeClanById(@PathVariable("id") int id){
        clanService.removeClanById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removeClanByName(@PathVariable("name") String name){
        clanService.removeClanByName(name);
    }
}

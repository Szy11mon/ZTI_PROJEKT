package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Panteon;
import com.biernacki.SpringProject.service.PanteonService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/panteons")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PanteonController {

    private final PanteonService panteonService;

    @Autowired
    public PanteonController(PanteonService panteonService) {
        this.panteonService = panteonService;
    }

    @PostMapping
    public void addPanteon (@Valid @NonNull @RequestBody Panteon panteon){
        this.panteonService.addPanteon(panteon);
    }

    @GetMapping
    public List<Panteon> getAllPanteons(){
        return panteonService.getAllPanteons();
    }

    @GetMapping(path = "{id}")
    public List<Panteon> getPanteonById(@PathVariable("id") int id){
        return panteonService.getPanteonById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getPanteonNameById(@PathVariable("id") int id){
        return panteonService.getPanteonNameById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removePanteonById(@PathVariable("id") int id){
        panteonService.removePanteonById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removePanteonByName(@PathVariable("name") String name){
        panteonService.removePanteonByName(name);
    }
}

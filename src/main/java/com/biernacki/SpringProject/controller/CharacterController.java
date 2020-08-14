package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Character;
import com.biernacki.SpringProject.model.CharacterNice;
import com.biernacki.SpringProject.service.CharacterService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/character")
@RestController
@CrossOrigin(origins = "https://neo4j-project.herokuapp.com")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public void addCharacterNice (@Valid @NonNull @RequestBody CharacterNice character){
        this.characterService.addCharacterNice(character);
    }

    @GetMapping
    public List<CharacterNice> getAllCharacterNice(){
        return characterService.getAllCharacterNice();
    }

    @GetMapping(path = "/standard")
    public List<Character> getAllCharacter(){
        return characterService.getAllCharacter();
    }

    @GetMapping(path = "{id}")
    public List<Character> getCharacterById(@PathVariable("id") int id){
        return characterService.getCharacterById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getCharacterNameById(@PathVariable("id") int id){
        return characterService.getCharacterNameById(id);
    }

    @GetMapping(path = "/getid/{name}")
    public int getCharacterIdByName(@PathVariable("name") String name){
        return characterService.getCharacterIdByName(name);
    }

    @DeleteMapping(path = "{id}")
    public void removeCharacterById(@PathVariable("id") int id){
        characterService.removeCharacterById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removeCharacterByName(@PathVariable("name") String name){
        characterService.removeCharacterByName(name);
    }
}

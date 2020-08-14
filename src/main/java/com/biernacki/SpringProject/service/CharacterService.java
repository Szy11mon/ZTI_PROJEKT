package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Character;
import com.biernacki.SpringProject.model.CharacterNice;
import com.biernacki.SpringProject.repository.CharacterRepository;
import com.biernacki.SpringProject.service.PanteonService;
import com.biernacki.SpringProject.service.ClassesService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Service
public class CharacterService {

    private final CharacterRepository databaseRepo;
    private final PanteonService panteonService;
    private final ClassesService classesService;

    @Autowired
    public CharacterService(@Qualifier("character") CharacterRepository databaseRepo, PanteonService panteonService,
        ClassesService classesService) {
        this.databaseRepo = databaseRepo;
        this.panteonService = panteonService;
        this.classesService = classesService;
    }

    public List<Character> getAllCharacter(){
        List<Character> character = databaseRepo.findAll();
        character.forEach(System.out::println);
        return character;
    }

    public List<CharacterNice> getAllCharacterNice(){
        List<CharacterNice> characterNice = new ArrayList<CharacterNice>();
        List<Character> character = databaseRepo.findAll();
        for (int i=0;i<character.size();i++){
            characterNice.add(new CharacterNice(
                character.get(i).getId(),
                panteonService.getPanteonNameById(character.get(i).getPanteonID()),
                classesService.getClassNameById(character.get(i).getClassID()),
                character.get(i).getName(),
                character.get(i).getDateAdded()));
        }
        characterNice.forEach(System.out::println);
        return characterNice;
    }

    public List<Character> getCharacterById( int id){
        List<Character> character = databaseRepo.findAllById(id);
        return character;
    }

    public void addCharacter(Character character) {
        databaseRepo.save(
                        new Character(
                              character.getPanteonID(),
                              character.getClassID(),
                              character.getName(),
                              character.getDateAdded()));
    }

    public void addCharacterNice(CharacterNice character) {
        databaseRepo.save(
                        new Character(
                              panteonService.getPanteonIdByName(character.getPanteon()),
                              classesService.getClassIdByName(character.getClassname()),
                              character.getName(),
                              character.getDateAdded()));
    }

    public void removeCharacterById(int id) {
        List<Character> foundCharacter = databaseRepo.findAllById(id);
        databaseRepo.delete(foundCharacter.get(0));
    }

    public String getCharacterNameById( int id){
        List<Character> character = databaseRepo.findAllById(id);
        return character.get(0).getName();
    }

    public int getCharacterIdByName(String name){
        List<Character> character = databaseRepo.findByName(name);
        return character.get(0).getId();
    }

    public void removeCharacterByName(String name) {
        List<Character> foundCharacter = databaseRepo.findByName(name);
        databaseRepo.delete(foundCharacter.get(0));
    }
}

package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Mode;
import com.biernacki.SpringProject.model.ModeNice;
import com.biernacki.SpringProject.service.ModeService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/mode")
@RestController
@CrossOrigin(origins = "https://neo4j-project.herokuapp.com")
public class ModeController {

    private final ModeService modeService;

    @Autowired
    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @PostMapping
    public void addModeNice (@Valid @NonNull @RequestBody ModeNice mode){
        this.modeService.addModeNice(mode);
    }

    @GetMapping
    public List<ModeNice> getAllModeNice(){
        return modeService.getAllModeNice();
    }

    @GetMapping(path = "/standard")
    public List<Mode> getAllMode(){
        return modeService.getAllMode();
    }

    @GetMapping(path = "{id}")
    public List<Mode> getModeById(@PathVariable("id") int id){
        return modeService.getModeById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getModeNameById(@PathVariable("id") int id){
        return modeService.getModeNameById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removeModeById(@PathVariable("id") int id){
        modeService.removeModeById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removeModeByName(@PathVariable("name") String name){
        modeService.removeModeByName(name);
    }
}

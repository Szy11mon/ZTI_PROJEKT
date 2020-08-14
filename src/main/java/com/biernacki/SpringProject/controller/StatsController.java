package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Stats;
import com.biernacki.SpringProject.model.StatsNice;
import com.biernacki.SpringProject.service.StatsService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/stats")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @PostMapping
    public void addStats (@Valid @NonNull @RequestBody StatsNice stats){
        this.statsService.addStatsNice(stats);
    }

    @GetMapping
    public List<StatsNice> getAllStatsNice(){
        return statsService.getAllStatsNice();
    }

    @GetMapping(path = "/standard")
    public List<Stats> getAllStats(){
        return statsService.getAllStats();
    }

    @GetMapping(path = "/player/{id}")
    public List<Stats> getStatsByPlayerId(@PathVariable("id") int id){
        return statsService.getStatsByPlayerId(id);
    }

    @GetMapping(path = "/mode/{id}")
    public List<Stats> getStatsByModeId(@PathVariable("id") int id){
        return statsService.getStatsByModeId(id);
    }

    @GetMapping(path = "{id}")
    public List<Stats> getStatsById(@PathVariable("id") int id){
        return statsService.getStatsById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removeStatsById(@PathVariable("id") int id){
        statsService.removeStatsById(id);
    }
}

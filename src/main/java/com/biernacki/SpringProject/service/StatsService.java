package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Stats;
import com.biernacki.SpringProject.model.StatsNice;
import com.biernacki.SpringProject.service.PlayerService;
import com.biernacki.SpringProject.service.ClanService;
import com.biernacki.SpringProject.service.CharacterService;
import com.biernacki.SpringProject.service.ModeService;
import com.biernacki.SpringProject.repository.StatsRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Service
public class StatsService {

    private final StatsRepository databaseRepo;
    private final PlayerService playerService;
    private final ClanService clanService;
    private final CharacterService characterService;
    private final ModeService modeService;

    @Autowired
    public StatsService(@Qualifier("stats") StatsRepository databaseRepo, PlayerService playerService,
        ClanService clanService, CharacterService characterService, ModeService modeService) {
        this.databaseRepo = databaseRepo;
        this.playerService = playerService;
        this.clanService = clanService;
        this.characterService = characterService;
        this.modeService = modeService;
    }

    public List<Stats> getAllStats(){
        List<Stats> stats = databaseRepo.findAll();
        stats.forEach(System.out::println);
        return stats;
    }

    public List<StatsNice> getAllStatsNice(){
        List<StatsNice> statsNice = new ArrayList<StatsNice>();
        List<Stats> stats = databaseRepo.findAll();
        for (int i=0;i<stats.size();i++){
            statsNice.add(new StatsNice(
                stats.get(i).getId(),
                playerService.getPlayerLoginById(stats.get(i).getPlayerID()),
                modeService.getModeNameById(stats.get(i).getModeID()),
                characterService.getCharacterNameById(stats.get(i).getCharacterID()),
                clanService.getClanNameById(stats.get(i).getClanID()),
                stats.get(i).getKills(),
                stats.get(i).getDeaths(),
                stats.get(i).getAssists(),
                stats.get(i).getGold(),
                stats.get(i).getDamage(),
                stats.get(i).getWin()));
        }
        statsNice.forEach(System.out::println);
        return statsNice;
    }

    public List<Stats> getStatsById( int id){
        List<Stats> stats = databaseRepo.findAllById(id);
        return stats;
    }

    public List<Stats> getStatsByPlayerId( int id){
        List<Stats> stats = databaseRepo.findByPlayerID(id);
        return stats;
    }

    public List<Stats> getStatsByModeId( int id){
        List<Stats> stats = databaseRepo.findByModeID(id);
        return stats;
    }

    public void addStats(Stats stats) {
        databaseRepo.save(
                        new Stats(
                            stats.getPlayerID(),
                            stats.getModeID(),
                            stats.getCharacterID(),
                            stats.getClanID(),
                            stats.getKills(),
                            stats.getDeaths(),
                            stats.getAssists(),
                            stats.getGold(),
                            stats.getDamage(),
                            stats.getWin()));
    }

    public void addStatsNice(StatsNice stats) {
        databaseRepo.save(
                        new Stats(
                            playerService.getPlayerIdByLogin(stats.getPlayer()),
                            modeService.getModeIdByName(stats.getMode()),
                            characterService.getCharacterIdByName(stats.getCharacter()),
                            clanService.getClanIdByName(stats.getClan()),
                            stats.getKills(),
                            stats.getDeaths(),
                            stats.getAssists(),
                            stats.getGold(),
                            stats.getDamage(),
                            stats.getWin()));
    }

    public void removeStatsById(int id) {
        List<Stats> foundStats = databaseRepo.findAllById(id);
        databaseRepo.delete(foundStats.get(0));
    }

}

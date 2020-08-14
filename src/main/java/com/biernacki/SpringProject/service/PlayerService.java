package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Player;
import com.biernacki.SpringProject.model.PlayerNice;
import com.biernacki.SpringProject.service.ClanService;
import com.biernacki.SpringProject.repository.PlayerRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Service
public class PlayerService {

    private final PlayerRepository databaseRepo;
    private final ClanService clanService;

    @Autowired
    public PlayerService(@Qualifier("player") PlayerRepository databaseRepo, ClanService clanService) {
        this.databaseRepo = databaseRepo;
        this.clanService = clanService;
    }

    public List<Player> getAllPlayer(){
        List<Player> player = databaseRepo.findAll();
        player.forEach(System.out::println);
        return player;
    }

    public List<PlayerNice> getAllPlayerNice(){
        List<PlayerNice> playerNice = new ArrayList<PlayerNice>();
        List<Player> player = databaseRepo.findAll();
        for (int i=0;i<player.size();i++){
            playerNice.add(new PlayerNice(
                player.get(i).getId(),
                player.get(i).getLogin(),
                clanService.getClanNameById(player.get(i).getClanID()),
                player.get(i).getDateJoined()));
        }
        playerNice.forEach(System.out::println);
        return playerNice;
    }

    public List<Player> getPlayerById( int id){
        List<Player> player = databaseRepo.findAllById(id);
        return player;
    }

    public String getPlayerLoginById( int id){
        List<Player> player = databaseRepo.findAllById(id);
        return player.get(0).getLogin();
    }

    public int getPlayerIdByLogin(String name){
        List<Player> player = databaseRepo.findByLogin(name);
        return player.get(0).getId();
    }

    public void addPlayer(Player player) {
        databaseRepo.save(
                        new Player(
                              player.getLogin(),
                              player.getClanID(),
                              player.getDateJoined()));
    }

    public void addPlayerNice(PlayerNice player) {
        databaseRepo.save(
                        new Player(
                              player.getLogin(),
                              clanService.getClanIdByName(player.getClan()),
                              player.getDateJoined()));
    }

    public void removePlayerById(int id) {
        List<Player> foundPlayer = databaseRepo.findAllById(id);
        databaseRepo.delete(foundPlayer.get(0));
    }

    public void removePlayerByName(String name) {
        List<Player> foundPlayer = databaseRepo.findByLogin(name);
        databaseRepo.delete(foundPlayer.get(0));
    }
}

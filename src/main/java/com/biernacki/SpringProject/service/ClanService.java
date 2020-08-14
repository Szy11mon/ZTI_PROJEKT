package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Clan;
import com.biernacki.SpringProject.repository.ClanRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClanService {

    private final ClanRepository databaseRepo;

    @Autowired
    public ClanService(@Qualifier("clan") ClanRepository databaseRepo) {
        this.databaseRepo = databaseRepo;
    }

    public List<Clan> getAllClan(){
        List<Clan> clan = databaseRepo.findAll();
        clan.forEach(System.out::println);
        return clan;
    }

    public List<Clan> getClanById( int id){
        List<Clan> clan = databaseRepo.findAllById(id);
        return clan;
    }

    public void addClan(Clan clan) {
        databaseRepo.save(
                        new Clan(
                              clan.getName()));
    }

    public void removeClanById(int id) {
        List<Clan> foundClan = databaseRepo.findAllById(id);
        databaseRepo.delete(foundClan.get(0));
    }

    public String getClanNameById( int id){
        List<Clan> clan = databaseRepo.findAllById(id);
        return clan.get(0).getName();
    }

    public int getClanIdByName(String name){
        List<Clan> clan = databaseRepo.findByName(name);
        return clan.get(0).getId();
    }

    public void removeClanByName(String name) {
        List<Clan> foundClan = databaseRepo.findByName(name);
        databaseRepo.delete(foundClan.get(0));
    }
}

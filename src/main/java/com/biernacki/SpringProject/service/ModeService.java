package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Mode;
import com.biernacki.SpringProject.model.ModeNice;
import com.biernacki.SpringProject.service.PanteonService;
import com.biernacki.SpringProject.repository.ModeRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@Service
public class ModeService {

    private final ModeRepository databaseRepo;
    private final PanteonService panteonService;

    @Autowired
    public ModeService(@Qualifier("mode") ModeRepository databaseRepo, PanteonService panteonService) {
        this.databaseRepo = databaseRepo;
        this.panteonService = panteonService;
    }

    public List<Mode> getAllMode(){
        List<Mode> mode = databaseRepo.findAll();
        mode.forEach(System.out::println);
        return mode;
    }

    public List<ModeNice> getAllModeNice(){
        List<ModeNice> modeNice = new ArrayList<ModeNice>();
        List<Mode> mode = databaseRepo.findAll();
        for (int i=0;i<mode.size();i++){
            modeNice.add(new ModeNice(
                mode.get(i).getId(),
                mode.get(i).getName(),
                panteonService.getPanteonNameById(mode.get(i).getPanteonID()),
                mode.get(i).getPlayersNumber()));
        }
        modeNice.forEach(System.out::println);
        return modeNice;
    }

    public List<Mode> getModeById( int id){
        List<Mode> mode = databaseRepo.findAllById(id);
        return mode;
    }

    public int getModeIdByName(String name){
        List<Mode> mode = databaseRepo.findByName(name);
        return mode.get(0).getId();
    }

    public String getModeNameById( int id){
        List<Mode> mode = databaseRepo.findAllById(id);
        return mode.get(0).getName();
    }

    public void addMode(Mode mode) {
        databaseRepo.save(
                        new Mode(
                              mode.getName(),
                              mode.getPanteonID(),
                              mode.getPlayersNumber()));
    }

    public void addModeNice(ModeNice mode) {
        databaseRepo.save(
                        new Mode(
                              mode.getName(),
                              panteonService.getPanteonIdByName(mode.getPanteon()),
                              mode.getPlayersNumber()));
    }

    public void removeModeById(int id) {
        List<Mode> foundMode = databaseRepo.findAllById(id);
        databaseRepo.delete(foundMode.get(0));
    }

    public void removeModeByName(String name) {
        List<Mode> foundMode = databaseRepo.findByName(name);
        databaseRepo.delete(foundMode.get(0));
    }
}

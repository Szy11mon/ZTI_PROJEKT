package com.biernacki.SpringProject.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Panteon;
import com.biernacki.SpringProject.repository.PanteonRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PanteonService {

    private final PanteonRepository databaseRepo;

    @Autowired
    public PanteonService(@Qualifier("panteon") PanteonRepository databaseRepo) {
        this.databaseRepo = databaseRepo;
    }

    public List<Panteon> getAllPanteons(){
        List<Panteon> panteons = databaseRepo.findAll();
        panteons.forEach(System.out::println);
        return panteons;
    }

    public List<Panteon> getPanteonById( int id){
        List<Panteon> panteons = databaseRepo.findAllById(id);
        return panteons;
    }

    public void addPanteon(Panteon panteon) {
        databaseRepo.save(
                        new Panteon(
                              panteon.getName(),
                              panteon.getDateAdded()));
    }

    public void removePanteonById(int id) {
        List<Panteon> foundPanteon = databaseRepo.findAllById(id);
        databaseRepo.delete(foundPanteon.get(0));
    }

    public String getPanteonNameById( int id){
        List<Panteon> panteons = databaseRepo.findAllById(id);
        return panteons.get(0).getName();
    }

    public int getPanteonIdByName(String name){
        List<Panteon> panteon = databaseRepo.findByName(name);
        return panteon.get(0).getId();
    }

    public void removePanteonByName(String name) {
        List<Panteon> foundPanteon = databaseRepo.findByName(name);
        databaseRepo.delete(foundPanteon.get(0));
    }
//    List<User> findByUsername(String username){}
//    List<User> findByUsernameContaining(String username){}
//    List<User> findByAgeGreaterThan(int age){}
//    List<User> findAllById(int id){}
//    List<User> findByCityIn(Collection<String> cities){}
}

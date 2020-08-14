package com.biernacki.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.biernacki.SpringProject.model.Classes;
import com.biernacki.SpringProject.repository.ClassesRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClassesService {

    private final ClassesRepository databaseRepo;

    @Autowired
    public ClassesService(@Qualifier("classes") ClassesRepository databaseRepo) {
        this.databaseRepo = databaseRepo;
    }

    public List<Classes> getAllClasses(){
        List<Classes> classes = databaseRepo.findAll();
        classes.forEach(System.out::println);
        return classes;
    }

    public List<Classes> getClassesById( int id){
        List<Classes> classes = databaseRepo.findAllById(id);
        return classes;
    }

    public void addClasses(Classes classes) {
        databaseRepo.save(
                        new Classes(
                              classes.getName(),
                              classes.getType()));
    }

    public void removeClassesById(int id) {
        List<Classes> foundClasses = databaseRepo.findAllById(id);
        databaseRepo.delete(foundClasses.get(0));
    }

    public String getClassNameById( int id){
        List<Classes> classes = databaseRepo.findAllById(id);
        return classes.get(0).getName();
    }

    public int getClassIdByName(String name){
        List<Classes> character = databaseRepo.findByName(name);
        return character.get(0).getId();
    }

    public void removeClassByName(String name) {
        List<Classes> foundClasses = databaseRepo.findByName(name);
        databaseRepo.delete(foundClasses.get(0));
    }
}

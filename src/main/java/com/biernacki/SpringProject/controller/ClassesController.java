package com.biernacki.SpringProject.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.biernacki.SpringProject.model.Classes;
import com.biernacki.SpringProject.service.ClassesService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/classes")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClassesController {

    private final ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @PostMapping
    public void addClasses (@Valid @NonNull @RequestBody Classes classes){
        this.classesService.addClasses(classes);
    }

    @GetMapping
    public List<Classes> getAllClasses(){
        return classesService.getAllClasses();
    }

    @GetMapping(path = "{id}")
    public List<Classes> getClassesById(@PathVariable("id") int id){
        return classesService.getClassesById(id);
    }

    @GetMapping(path = "/getname/{id}")
    public String getClassNameById(@PathVariable("id") int id){
        return classesService.getClassNameById(id);
    }

    @DeleteMapping(path = "{id}")
    public void removeClassesById(@PathVariable("id") int id){
        classesService.removeClassesById(id);
    }

    @DeleteMapping(path = "/name/{name}")
    public void removeClassByName(@PathVariable("name") String name){
        classesService.removeClassByName(name);
    }
}

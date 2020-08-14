package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Classes;

import java.util.Collection;
import java.util.List;

@Repository("classes")
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    List<Classes> findByName(String name);
    List<Classes> findByNameContaining(String name);;
    List<Classes> findAllById(int id);
}

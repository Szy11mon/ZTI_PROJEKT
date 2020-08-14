package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Panteon;

import java.util.Collection;
import java.util.List;

@Repository("panteon")
public interface PanteonRepository extends JpaRepository<Panteon, Long> {
    List<Panteon> findByName(String name);
    List<Panteon> findByNameContaining(String name);;
    List<Panteon> findAllById(int id);
}

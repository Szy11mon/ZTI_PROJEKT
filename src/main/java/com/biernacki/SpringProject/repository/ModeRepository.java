package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Mode;

import java.util.Collection;
import java.util.List;

@Repository("mode")
public interface ModeRepository extends JpaRepository<Mode, Long> {
    List<Mode> findByName(String name);
    List<Mode> findByNameContaining(String name);;
    List<Mode> findAllById(int id);
}

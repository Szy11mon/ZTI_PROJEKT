package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Clan;

import java.util.Collection;
import java.util.List;

@Repository("clan")
public interface ClanRepository extends JpaRepository<Clan, Long> {
    List<Clan> findByName(String name);
    List<Clan> findAllById(int id);
}

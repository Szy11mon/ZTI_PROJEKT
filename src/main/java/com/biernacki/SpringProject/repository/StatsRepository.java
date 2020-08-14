package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Stats;

import java.util.Collection;
import java.util.List;

@Repository("stats")
public interface StatsRepository extends JpaRepository<Stats, Long> {
    List<Stats> findByPlayerID(int playerID);
    List<Stats> findByModeID(int modeID);
    List<Stats> findByCharacterID(int characterID);
    List<Stats> findByClanID(int clanID);
    List<Stats> findAllById(int id);
}

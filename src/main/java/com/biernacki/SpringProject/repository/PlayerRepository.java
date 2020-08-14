package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Player;

import java.util.Collection;
import java.util.List;

@Repository("player")
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByLogin(String login);
    List<Player> findByLoginContaining(String login);;
    List<Player> findAllById(int id);
}

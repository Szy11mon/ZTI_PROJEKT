package com.biernacki.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biernacki.SpringProject.model.Character;

import java.util.Collection;
import java.util.List;

@Repository("character")
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByName(String name);
    List<Character> findByNameContaining(String name);;
    List<Character> findAllById(int id);
}

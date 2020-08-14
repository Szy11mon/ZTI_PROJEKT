package com.biernacki.SpringProject.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int playerID;
    private int modeID;
    private int characterID;
    private int clanID;
    private int kills;
    private int deaths;
    private int assists;
    private int gold;
    private int damage;
    private String win;

    public Stats(@JsonProperty("playerID") int playerID, @JsonProperty("modeID") int modeID,
        @JsonProperty("characterID") int characterID, @JsonProperty("clanID") int clanID,
        @JsonProperty("kills") int kills, @JsonProperty("deaths") int deaths,
        @JsonProperty("assists") int assists, @JsonProperty("gold") int gold,
        @JsonProperty("damage") int damage, @JsonProperty("win") String win) {
        this.playerID = playerID;
        this.modeID = modeID;
        this.characterID = characterID;
        this.clanID = clanID;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.gold = gold;
        this.damage = damage;
        this.win = win;
    }
}

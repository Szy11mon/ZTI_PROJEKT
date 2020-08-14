package com.biernacki.SpringProject.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatsNice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String player;
    private String mode;
    private String character;
    private String clan;
    private int kills;
    private int deaths;
    private int assists;
    private int gold;
    private int damage;
    private String win;

}

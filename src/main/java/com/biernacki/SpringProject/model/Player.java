package com.biernacki.SpringProject.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private int clanID;
    private Date dateJoined;

    public Player(@JsonProperty("login") String login, @JsonProperty("clanID") int clanID,
        @JsonProperty("dateJoined") Date dateJoined) {
        this.login = login;
        this.clanID = clanID;
        this.dateJoined = dateJoined;
    }
}

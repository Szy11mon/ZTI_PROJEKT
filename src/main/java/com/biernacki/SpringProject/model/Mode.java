package com.biernacki.SpringProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "modes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int panteonID;
    private int playersNumber;

    public Mode(@JsonProperty("name") String name, @JsonProperty("panteonID") int panteonID, @JsonProperty("playersNumber") int playersNumber) {
        this.name = name;
        this.panteonID = panteonID;
        this.playersNumber = playersNumber;
    }
}

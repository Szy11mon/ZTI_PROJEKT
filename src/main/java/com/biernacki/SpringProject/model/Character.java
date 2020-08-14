package com.biernacki.SpringProject.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int panteonID;
    private int classID;
    private String name;
    private Date dateAdded;

    public Character(@JsonProperty("panteonID") int panteonID, @JsonProperty("classID") int classID,
        @JsonProperty("name") String name, @JsonProperty("dateAdded") Date dateAdded) {
        this.panteonID = panteonID;
        this.classID = classID;
        this.name = name;
        this.dateAdded = dateAdded;
    }
}

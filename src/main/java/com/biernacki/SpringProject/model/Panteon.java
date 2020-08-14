package com.biernacki.SpringProject.model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "panteons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Panteon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Date dateAdded;

    public Panteon(@JsonProperty("name") String name, @JsonProperty("dateAdded") Date dateAdded) {
        this.name = name;
        this.dateAdded = dateAdded;
    }
}

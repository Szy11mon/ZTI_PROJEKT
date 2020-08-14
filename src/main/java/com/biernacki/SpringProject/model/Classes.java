package com.biernacki.SpringProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;

    public Classes(@JsonProperty("name") String name, @JsonProperty("type") String type) {
        this.name = name;
        this.type = type;
    }
}

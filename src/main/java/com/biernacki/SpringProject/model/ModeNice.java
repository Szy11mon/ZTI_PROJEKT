package com.biernacki.SpringProject.model;

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
public class ModeNice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String panteon;
    private int playersNumber;

}

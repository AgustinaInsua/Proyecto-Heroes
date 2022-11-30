package com.example.bdf.model.entity;

import com.example.bdf.model.bo.HeroBO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "weaknesses")
public class WeaknessDE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    private String name;

    private String description;

}

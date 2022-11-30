package com.example.bdf.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "universe")
public class UniverseDE {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

  //  @Column(nullable = false)
    private String name;

    private String description;

}

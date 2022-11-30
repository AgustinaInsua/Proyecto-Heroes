package com.example.bdf.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "partner")
@Getter
@Setter
public class PartnerDE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

 //   @Column(nullable = false)
    private String name;

}

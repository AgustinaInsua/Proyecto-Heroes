package com.example.bdf.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = "gender")
public class GenderDE {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (nullable = false)
    private String code;

    @Column (nullable = false)
    private String description;

}

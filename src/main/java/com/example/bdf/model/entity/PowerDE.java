package com.example.bdf.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name ="powers")
public class PowerDE {

    @Id
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "power")
    private List<Hero_PowerDE> heroes;

}

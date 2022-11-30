package com.example.bdf.model.entity;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "Hero_Power")
public class Hero_PowerDE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private HeroEntity hero;

    @ManyToOne
    @JoinColumn(name = "power_id")
    private PowerDE power;

    private String event;

    private Date event_date;

    private boolean active;


}

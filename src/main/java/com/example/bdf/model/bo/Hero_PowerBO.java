package com.example.bdf.model.bo;


import lombok.*;


import java.util.Date;

@Data
public class Hero_PowerBO {

    private Long id;

    private HeroBO hero;

    private PowerBO power;

    private String event;

    private Date event_date;

}

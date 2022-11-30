package com.example.bdf.controller.dto;

import com.example.bdf.model.bo.HeroBO;
import com.example.bdf.model.bo.PowerBO;
import lombok.Data;

import java.util.Date;

@Data
public class Hero_PowerDTO {

    private Long id;

    private HeroBO hero;

    private PowerBO power;

    private String event;

    private Date event_date;

}

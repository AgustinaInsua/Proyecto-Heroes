package com.example.bdf.model.bo;


import com.example.bdf.model.entity.*;
import lombok.*;

import java.util.List;

@Data
public class HeroBO {

    private Long id;

    private String name;

    private String city;

    private EnemyBO enemy;

    private UniverseBO universe;

    private List<Hero_PowerBO> powers;

    private AlterEgoBO alterEgo;

    private GenderBO gender;

    private PartnerBO partner;

    private List<WeaknessBO> weaknesses;

    private TypeBO type;
}

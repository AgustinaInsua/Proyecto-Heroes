package com.example.bdf.model.bo;

import com.example.bdf.repository.Hero_PowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hero_PowerServiceBO {

    private final PowerServiceBO powerServiceBO;

    private final Hero_PowerRepository hero_powerRepository;

    @Autowired
    public Hero_PowerServiceBO(PowerServiceBO powerServiceBO, Hero_PowerRepository hero_powerRepository) {
        this.powerServiceBO = powerServiceBO;
        this.hero_powerRepository = hero_powerRepository;
    }

    public PowerBO getPowerByName(String name) {
        return powerServiceBO.getPowerByName(name);
    }

}

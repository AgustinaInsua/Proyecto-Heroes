package com.example.bdf.service.imp;

import com.example.bdf.model.bo.PowerBO;
import com.example.bdf.model.bo.PowerServiceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerServiceImp {

    private final PowerServiceBO powerServiceBO;

    @Autowired
    public PowerServiceImp(PowerServiceBO powerServiceBO) {
        this.powerServiceBO = powerServiceBO;
    }

    public PowerBO getPower(String name){
        return this.powerServiceBO.getPowerByName(name);
    }
}

package com.example.bdf.model.bo;

import com.example.bdf.model.entity.PowerDE;
import com.example.bdf.model.mapper.PowerMapper;
import com.example.bdf.model.mapper.TypeMapper;
import com.example.bdf.repository.PowerRepository;
import com.example.bdf.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PowerServiceBO {

    private final PowerRepository powerRepository;

    private final PowerMapper powerMapper;

    @Autowired
    public PowerServiceBO(PowerRepository powerRepository, PowerMapper powerMapper) {
        this.powerRepository = powerRepository;
        this.powerMapper = powerMapper;
    }

    public PowerBO getPowerByName(String name) {
        return powerMapper.powerDEtoBO(powerRepository.getPowerByName(name));
    }



    public List<PowerBO> getAll() {
        return powerRepository.findAll().stream()
                .map(this.powerMapper::powerDEtoBO)
                .collect(Collectors.toList());
    }
}

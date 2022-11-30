package com.example.bdf.service.interfaces;


import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.controller.dto.UniverseDTO;
import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.entity.HeroEntity;
import com.example.bdf.model.entity.UniverseDE;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniverseService {

    public List<UniverseDTO> getUniverse();

    public UniverseDTO findById(Long id) throws NotFoundException;

    public UniverseDTO create(UniverseDTO universeDTO);

    public UniverseDTO update(Long id, UniverseDTO universeDTO);

    public void deleteOneById(Long id);

  // UniverseDE getUniverseByCode(String codeUniverse);
}

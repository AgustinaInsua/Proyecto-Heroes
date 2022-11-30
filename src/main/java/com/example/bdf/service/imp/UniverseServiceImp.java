package com.example.bdf.service.imp;

import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.controller.dto.UniverseDTO;
import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.bo.UniverseServiceBO;
import com.example.bdf.model.mapper.UniverseMapper;
import com.example.bdf.service.interfaces.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniverseServiceImp implements UniverseService {


    private final UniverseMapper universeMapper;
    private final UniverseServiceBO universeServiceBO;

    @Autowired
    public UniverseServiceImp(UniverseMapper universeMapper, UniverseServiceBO universeServiceBO) {
        this.universeMapper = universeMapper;
        this.universeServiceBO = universeServiceBO;
    }

    @Override
    public List<UniverseDTO> getUniverse() {
        return universeServiceBO.getGenders()
                .stream()
                .map(this.universeMapper::universeBOtoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UniverseDTO findById(Long id) throws NotFoundException {
        return universeMapper.universeBOtoDTO(universeServiceBO.findById(id));
    }

    public UniverseDTO create(UniverseDTO universeDTO) {
        return universeMapper.universeBOtoDTO(universeServiceBO.
                create(universeMapper.universeDTOtoBO(universeDTO)));
    }

    @Override
    public UniverseDTO update(Long id,UniverseDTO universeDTO) {
        return universeMapper.universeBOtoDTO(universeServiceBO.update(id,universeMapper.universeDTOtoBO(universeDTO)));
    }

    @Override
    public void deleteOneById(Long id) {
        universeServiceBO.deleteOneById(id);
    }

 /*   public UniverseDE getUniverseByCode(String codeUniverse) {
        UniverseDE universeDE = new UniverseDE();
        universeDE.setCode(codeUniverse);
        return universeDE;
    } */
}

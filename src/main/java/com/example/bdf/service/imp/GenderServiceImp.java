package com.example.bdf.service.imp;

import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.model.bo.GenderServiceBO;
import com.example.bdf.model.entity.GenderDE;
import com.example.bdf.model.mapper.GenderMapper;
import com.example.bdf.service.interfaces.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImp implements GenderService {

    private final GenderMapper genderMapper;
    private final GenderServiceBO genderServiceBO;


    @Autowired
    public GenderServiceImp(GenderMapper genderMapper, GenderServiceBO genderServiceBO) {
        this.genderMapper = genderMapper;
        this.genderServiceBO = genderServiceBO;
    }

    @Override
    public GenderDE getGenderDEByCode(String codeGender) {
        GenderDE genderDE = new GenderDE();
        genderDE.setCode(codeGender);
        return genderDE;
    }

    @Override
    public List<GenderDTO> getGender() {
        return genderServiceBO.getGenders()
                .stream()
                .map(this.genderMapper::genderBOtoDTO)
                .collect(Collectors.toList());
    }


    @Override
    public GenderDTO findById(Long id)  {
        return this.genderMapper.genderBOtoDTO(genderServiceBO.findById(id));
    }

    public GenderDTO create(GenderDTO genderDTO) {
        return genderMapper.genderBOtoDTO(genderServiceBO.
                createHero(genderMapper.genderDTOtoBO(genderDTO)));
    }

    @Override
    public GenderDTO update(Long id, GenderDTO genderDTO) {
        return genderMapper.genderBOtoDTO(genderServiceBO.update(id,genderMapper.genderDTOtoBO(genderDTO)));
    }

    @Override
    public void deleteOneById(Long id) {
        genderServiceBO.deleteOneById(id);
    }


}

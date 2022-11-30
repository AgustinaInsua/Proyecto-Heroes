package com.example.bdf.model.mapper;


import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.controller.dto.TypeDTO;
import com.example.bdf.model.bo.GenderBO;
import com.example.bdf.model.bo.TypeBO;
import com.example.bdf.model.entity.GenderDE;
import com.example.bdf.model.entity.TypeDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    GenderDE genderDTOtoDE(GenderDTO genderDTO);

    GenderDE genderBOtoDE(GenderBO genderBO);

    GenderDTO genderDEtoDTO(GenderDE genderDE);

    GenderDTO genderBOtoDTO(GenderBO genderBO);

    GenderBO genderDTOtoBO(GenderDTO genderDTO);

    GenderBO genderDEtoBO(GenderDE genderDE);

}

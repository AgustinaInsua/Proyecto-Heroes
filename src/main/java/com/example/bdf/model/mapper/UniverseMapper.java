package com.example.bdf.model.mapper;

import com.example.bdf.controller.dto.UniverseDTO;
import com.example.bdf.model.bo.UniverseBO;
import com.example.bdf.model.entity.UniverseDE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UniverseMapper {


    UniverseDE universeDTOtoDE(UniverseDTO universeDTO);

    UniverseDE universeBOtoDE(UniverseBO universeBO);

    UniverseDTO universeDEtoDTO(UniverseDE universeDE);

    UniverseDTO universeBOtoDTO(UniverseBO universeBO);

    UniverseBO universeDTOtoBO(UniverseDTO universeDTO);

    UniverseBO universeDEtoBO(UniverseDE universeDE);

}

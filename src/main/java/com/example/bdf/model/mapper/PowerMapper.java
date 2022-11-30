package com.example.bdf.model.mapper;

import com.example.bdf.controller.dto.PowerDTO;
import com.example.bdf.controller.dto.TypeDTO;
import com.example.bdf.model.bo.PowerBO;
import com.example.bdf.model.bo.TypeBO;
import com.example.bdf.model.entity.PowerDE;
import com.example.bdf.model.entity.TypeDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PowerMapper {

    PowerDE powerDTOtoDE(PowerDTO powerDTO);

    PowerDE powerBOtoDE(PowerBO powerBO);

    PowerDTO powerDEtoDTO(PowerDE powerDE);

    PowerDTO powerBOtoDTO(PowerBO powerBO);

    PowerBO powerDTOtoBO(PowerDTO powerDTO);

    PowerBO powerDEtoBO(PowerDE powerDE);

}

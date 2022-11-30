package com.example.bdf.model.mapper;


import com.example.bdf.controller.dto.TypeDTO;
import com.example.bdf.model.bo.TypeBO;
import com.example.bdf.model.entity.TypeDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    TypeDE typeDTOtoDE(TypeDTO typeDTO);

    TypeDE typeBOtoDE(TypeBO typeBO);

    TypeDTO typeDEtoDTO(TypeDE typeDE);

    TypeDTO typeBOtoDTO(TypeBO typeBO);

    TypeBO typeDTOtoBO(TypeDTO typeDTO);

    TypeBO typeDEtoBO(TypeDE typeDE);

}

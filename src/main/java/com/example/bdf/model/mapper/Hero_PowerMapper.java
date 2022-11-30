package com.example.bdf.model.mapper;

import com.example.bdf.model.bo.GenderBO;
import com.example.bdf.model.bo.Hero_PowerBO;
import com.example.bdf.model.entity.GenderDE;
import com.example.bdf.model.entity.Hero_PowerDE;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface Hero_PowerMapper {


    Hero_PowerBO hero_PowerDEtoBO(Hero_PowerDE hero_powerDE);

}

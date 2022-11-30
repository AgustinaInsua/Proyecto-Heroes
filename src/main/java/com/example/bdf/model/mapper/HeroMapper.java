package com.example.bdf.model.mapper;


import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.model.bo.HeroBO;
import com.example.bdf.model.bo.Hero_PowerBO;
import com.example.bdf.model.bo.PowerBO;
import com.example.bdf.model.bo.WeaknessBO;
import com.example.bdf.model.entity.HeroEntity;
import com.example.bdf.model.entity.Hero_PowerDE;
import com.example.bdf.model.entity.PowerDE;
import com.example.bdf.model.entity.WeaknessDE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mapping(target = "enemy", source = "heroEntity.enemy.name")
    @Mapping(target = "partner", source = "heroEntity.partner.name")
    @Mapping(target = "alterEgo", source = "alterEgo.name")

    @Mapping(target = "descriptionGender" , source = "heroEntity.gender.description")
    @Mapping(target = "descriptionType" , source = "heroEntity.type.description")
    @Mapping(target = "descriptionUniverse" , source = "heroEntity.universe.description")

    @Mapping(target = "powers", ignore = true)
    @Mapping(target = "weaknesses", ignore = true)
    HeroDTO heroDEtoHeroDTO(HeroEntity heroEntity);

    @Mapping(target = "enemy.name", source = "enemy")
    @Mapping(target = "alterEgo.name", source = "alterEgo")
    @Mapping(target = "partner.name", source = "partner")

    @Mapping(target = "universe.description" , source = "descriptionUniverse")
    @Mapping(target = "type.description" , source = "descriptionType")
    @Mapping(target = "gender.description" , source = "descriptionGender")
    @Mapping(target = "powers", ignore = true)
    @Mapping(target = "weaknesses", ignore = true)
    HeroEntity heroDTOtoHeroDE(HeroDTO heroDTO);

    @Mapping(target = "enemy.name", source = "enemy")
    @Mapping(target = "alterEgo.name", source = "alterEgo")
    @Mapping(target = "partner.name", source = "partner")

    @Mapping(target = "powers", ignore = true)
    //@Mapping(target = "powers", source = "heroDTO.powers")
    @Mapping(target = "weaknesses", source = "heroDTO.weaknesses")
    @Mapping(target = "universe.description", source = "descriptionUniverse")
    @Mapping(target = "type.description" , source = "descriptionType")
    @Mapping(target = "gender.description" , source = "descriptionGender")

    HeroBO heroDTOtoHeroBO(HeroDTO heroDTO);

    List<WeaknessDE> stringToWeakness(List<String> listWeakness);

    default WeaknessDE listOfStringToWeakness(String weakness){
        WeaknessDE w = new WeaknessDE();
        w.setDescription(weakness);
        return w;
    }

    List<WeaknessBO> stringToWeaknessBO(List<String> listWeakness);

    default WeaknessBO listOfStringToWeaknessBO(String weakness){
        WeaknessBO w = new WeaknessBO();
        w.setDescription(weakness);
        return w;
    }

    List<Hero_PowerDE> stringToHero_Power(List<String> listPowers);

    default Hero_PowerDE stringToHeroPowerDE(String powers){
        Hero_PowerDE h = new Hero_PowerDE();
        PowerDE p = new PowerDE();
        p.setName(powers);
        h.setPower(p);
        return h;
    }
    List<Hero_PowerBO> stringToHero_PowerBO(List<String> listPowers);

    default Hero_PowerBO stringToHeroPowerBO(String powers){
        Hero_PowerBO h = new Hero_PowerBO();
        PowerBO p = new PowerBO();
        p.setName(powers);
        h.setPower(p);
        return h;
    }

    List<Hero_PowerBO> heroPowerDEToHeroPower(List<Hero_PowerDE> heroPower);

    default Hero_PowerBO heroPowerDEToHeroPowerBO(Hero_PowerDE heroPower){
        Hero_PowerBO hp = new Hero_PowerBO();
        PowerBO p = new PowerBO();
        p.setName(heroPower.getPower().getName());
        p.setId(heroPower.getPower().getId());
        hp.setPower(p);
        return hp;
    }

    List<Hero_PowerDE> heroPowerBOToHeroPower(List<Hero_PowerBO> heroPower);

    default Hero_PowerDE heroPowerBOToHeroPowerDE(Hero_PowerBO heroPower){
        Hero_PowerDE hp = new Hero_PowerDE();
        PowerDE p = new PowerDE();
        p.setName(heroPower.getPower().getName());
        p.setId(heroPower.getPower().getId());
        hp.setPower(p);
        return hp;
    }


    @Mapping(target = "enemy", source = "heroBO.enemy.name")
    @Mapping(target = "partner", source = "heroBO.partner.name")
    @Mapping(target = "alterEgo", source = "heroBO.alterEgo.name")

    @Mapping(target = "descriptionGender" , source = "gender.description")
    @Mapping(target = "descriptionType" , source = "type.description")

 //   @Mapping(target = "powers", source = "heroBO.powers")
    @Mapping(target = "powers", ignore = true)
    @Mapping(target = "weaknesses", source = "heroBO.weaknesses")
    @Mapping(target = "descriptionUniverse", source = "universe.description")
    HeroDTO heroBOtoHeroDTO(HeroBO heroBO);

    List<String> weaknessToString(List<WeaknessDE> weaknessDE);

    default String map (WeaknessDE weakness){
        return weakness.getDescription();
    }

    List<String> weaknessBOToString(List<WeaknessBO> weaknessBO);

    default String weaknessBOToString (WeaknessBO weakness){
        return weakness.getDescription();
    }

    List<String> hero_PowerDEToString(List<Hero_PowerDE> listPowers);

    default String heroPowerDEToString (Hero_PowerDE hero_powerDE){
        return hero_powerDE.getPower().getName();
    }

    List<String> hero_PowerBOToString(List<Hero_PowerBO> listPowers);

    default String heroPowerBOToString (Hero_PowerBO hero_powerBO){
        return hero_powerBO.getPower().getName();
    }
 //   @Mapping(target = "powers", source = "heroEntity.powers")
    HeroBO heroDEtoHeroBO(HeroEntity heroEntity);

 //   @Mapping(target = "powers", source = "heroBO.powers")
    @Mapping(target = "powers", ignore = true)
    @Mapping(target = "enemy.name", source = "heroBO.enemy.name")
    @Mapping(target = "universe.description", source = "heroBO.universe.description")
    @Mapping(target = "gender.description", source = "heroBO.gender.description")
    @Mapping(target = "type.description", source = "heroBO.type.description")
    @Mapping(target = "alterEgo.name", source = "heroBO.alterEgo.name")
    @Mapping(target = "partner.name", source = "heroBO.partner.name")
    @Mapping(target = "weaknesses", source = "heroBO.weaknesses")
    HeroEntity heroBOtoHeroDE(HeroBO heroBO);

}

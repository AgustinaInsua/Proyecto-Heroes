package com.example.bdf.service.imp;

import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.controller.dto.Hero_PowerDTO;
import com.example.bdf.model.bo.HeroServiceBO;
import com.example.bdf.model.mapper.HeroMapper;
import com.example.bdf.service.interfaces.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HeroServiceImp implements HeroService {

    private final HeroMapper heroMapper;
    private final HeroServiceBO heroServiceBO;


    @Autowired
    public HeroServiceImp(HeroMapper heroMapper, HeroServiceBO heroServiceBO) {
        this.heroMapper = heroMapper;
        this.heroServiceBO = heroServiceBO;
    }

    @Override
    public List<HeroDTO> getHeroes() {
        return heroServiceBO.getHeroes()
                        .stream()
                        .map(this.heroMapper::heroBOtoHeroDTO)
                        .collect(Collectors.toList());
    }

    public List<HeroDTO> getHeroesByUniverse(String universe){
        return heroServiceBO.getHeroesByUniverse(universe)
                .stream().parallel()
                .map(this.heroMapper::heroBOtoHeroDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HeroDTO findById(Long id)  {
        return this.heroMapper.heroBOtoHeroDTO(heroServiceBO.findById(id));
    }

    public HeroDTO create(HeroDTO hero) {
        return heroMapper.heroBOtoHeroDTO(heroServiceBO.
                createHero(heroMapper.heroDTOtoHeroBO(hero)));
    }

    @Override
    public HeroDTO updateHero(Long id, HeroDTO heroDTO) {
        return heroMapper.heroBOtoHeroDTO(heroServiceBO.updateHero(id,heroMapper.heroDTOtoHeroBO(heroDTO)));
    }

    @Override
    public void deleteOneById(Long id) {
        heroServiceBO.deleteOneById(id);
    }


    public Hero_PowerDTO addHeroPower(Hero_PowerDTO heroPowerDTO) {

        return heroPowerDTO;
    }
}

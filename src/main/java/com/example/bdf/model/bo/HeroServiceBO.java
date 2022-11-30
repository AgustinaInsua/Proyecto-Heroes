package com.example.bdf.model.bo;

import com.example.bdf.exception.BadRequestException;
import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.entity.HeroEntity;
import com.example.bdf.model.entity.Hero_PowerDE;
import com.example.bdf.model.mapper.HeroMapper;
import com.example.bdf.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HeroServiceBO {

    private final HeroMapper heroMapper;
    private final HeroRepository heroRepository;
    private final UniverseServiceBO universeServiceBO;
    private final TypeServiceBO typeServiceBO;
    private final GenderServiceBO genderServiceBO;
    private final PowerServiceBO powerServiceBO;
    private final Hero_PowerServiceBO hero_powerServiceBO;

    @Autowired
    public HeroServiceBO(HeroMapper heroMapper, HeroRepository heroRepository, UniverseServiceBO universeServiceBO, TypeServiceBO typeServiceBO, GenderServiceBO genderServiceBO, PowerServiceBO powerServiceBO, Hero_PowerServiceBO hero_powerServiceBO) {
        this.heroMapper = heroMapper;
        this.heroRepository = heroRepository;
        this.universeServiceBO = universeServiceBO;
        this.typeServiceBO = typeServiceBO;
        this.genderServiceBO = genderServiceBO;
        this.powerServiceBO = powerServiceBO;
        this.hero_powerServiceBO = hero_powerServiceBO;
    }

    public List<HeroBO> getHeroes() {
        return heroRepository.findAll()
                .stream()
                .map(this.heroMapper::heroDEtoHeroBO)
                .collect(Collectors.toList());
    }

    public HeroBO createHero(HeroBO hero){

        hero.setUniverse(universeServiceBO.getUniverseByDescription(hero.getUniverse().getDescription()));
        hero.setType(typeServiceBO.getTypeByDescription(hero.getType().getDescription()));
        hero.setGender(genderServiceBO.getGenderByDescription(hero.getGender().getDescription()));
       /* HeroEntity heroDE = this.heroMapper.heroBOtoHeroDE(hero);

        for (Hero_PowerBO power : hero.getPowers()){
            power.setPower(powerServiceBO.getPowerByName(power.getPower().getName()));
        }

        for (Hero_PowerDE power : heroDE.getPowers()){
            power.setHero(heroDE);
        } */

        return this.heroMapper.heroDEtoHeroBO(heroRepository.save(heroMapper.heroBOtoHeroDE(hero)));
    }

    public List<HeroBO> getHeroesByUniverse(String universe) {
        return heroRepository.findByUniverse_Description(universe)
                .stream().map(this.heroMapper::heroDEtoHeroBO).collect(Collectors.toList());
    }

    public HeroBO findById(Long id)  {
        heroRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found heroe with id " + id));
        return this.heroMapper.heroDEtoHeroBO(heroRepository.findByIdEquals(id));
    }

    public HeroBO updateHero(Long id, HeroBO heroBO) {
        heroRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found heroe with id " + id));
        HeroBO newHero = new HeroBO();
        newHero.setName(heroBO.getName());
        return this.heroMapper.heroDEtoHeroBO(heroRepository.save(heroMapper.heroBOtoHeroDE(newHero)));
    }

    public void deleteOneById(Long id) {
        heroRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found heroe with id " + id));
        heroRepository.delete(heroRepository.findById(id).get());
    }

}

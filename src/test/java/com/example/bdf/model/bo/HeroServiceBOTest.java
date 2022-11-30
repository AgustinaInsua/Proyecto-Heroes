package com.example.bdf.model.bo;

import com.example.bdf.model.mapper.HeroMapper;
import com.example.bdf.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


class HeroServiceBOTest {

    @Mock
    private HeroRepository heroRepository;
    @Mock
    private HeroMapper heroMapper;
    @Mock
    private UniverseServiceBO universeServiceBO;
    @Mock
    private TypeServiceBO typeServiceBO;
    @Mock
    private GenderServiceBO genderServiceBO;
    @Mock
    private PowerServiceBO powerServiceBO;

    @InjectMocks
    private HeroServiceBO heroServiceBO;

    @BeforeEach
    public void setUp (){
        MockitoAnnotations.initMocks(this);
        HeroBO hero = new HeroBO();
        hero.setName("Flash");
        hero.setCity("Central City");
   //     hero.setEnemy("Reverse Flash");
     //   hero.setAlterEgo("Barry Allen");
    //    hero.setPartner("Cisco");
        hero.setUniverse(universeServiceBO.getUniverseByDescription(hero.getUniverse().getDescription()));
        hero.setType(typeServiceBO.getTypeByDescription(hero.getType().getDescription()));
        hero.setGender(genderServiceBO.getGenderByDescription(hero.getGender().getDescription()));
        List<String> weaknesses = new ArrayList<>();
        weaknesses.add("inmaduro");
        weaknesses.add("desconfiado");

        heroMapper.heroDEtoHeroBO(heroRepository.save(heroMapper.heroBOtoHeroDE(hero)));
    }

    void testSaveHero(){

    }

    void testListarHeroes(){

    }

    void testListarHeroVacio(){

    }

    void testObtenerHeroPorId(){

    }

    void testActualizarHero(){

    }

    void testEliminarHero(){

    }


}
package com.example.bdf.service.interfaces;

import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.exception.NotFoundException;

import java.util.List;

public interface HeroService {

    public List<HeroDTO> getHeroes();

    public HeroDTO findById(Long id) throws NotFoundException;

    public HeroDTO create(HeroDTO heroDTO) throws Exception;

    public HeroDTO updateHero(Long id, HeroDTO heroDTO);

    public void deleteOneById(Long id);

}

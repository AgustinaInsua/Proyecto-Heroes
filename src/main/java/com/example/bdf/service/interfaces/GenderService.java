package com.example.bdf.service.interfaces;


import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.entity.GenderDE;

import java.util.List;

public interface GenderService {

   GenderDE getGenderDEByCode(String codeGender);

   public List<GenderDTO> getGender();

   public GenderDTO findById(Long id) throws NotFoundException;

   public GenderDTO create(GenderDTO genderDTO) throws Exception;

   public GenderDTO update(Long id, GenderDTO genderDTO);

   public void deleteOneById(Long id);

}

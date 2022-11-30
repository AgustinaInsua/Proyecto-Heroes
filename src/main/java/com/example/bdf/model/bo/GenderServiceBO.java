package com.example.bdf.model.bo;

import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.mapper.GenderMapper;
import com.example.bdf.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceBO {

    private final GenderRepository genderRepository;

    private final GenderMapper genderMapper;

    @Autowired
    public GenderServiceBO(GenderRepository genderRepository, GenderMapper genderMapper) {
        this.genderRepository = genderRepository;
        this.genderMapper = genderMapper;
    }


    public GenderBO getGenderByDescription(String descriptionGender) {
        return genderMapper.genderDEtoBO(genderRepository.getGenderByDescription(descriptionGender));
    }

    public List<GenderBO> getGenders() {
        return genderRepository.findAll()
                .stream()
                .map(this.genderMapper::genderDEtoBO)
                .collect(Collectors.toList());
    }

    public GenderBO createHero(GenderBO genderBO){
        getGenderByDescription(genderBO.getDescription());
        return this.genderMapper.genderDEtoBO(genderRepository.save(genderMapper.genderBOtoDE(genderBO)));
    }

    public GenderBO findById(Long id)  {
        genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found gender with id " + id));
        return this.genderMapper.genderDEtoBO(genderRepository.findByIdEquals(id));
    }

    public GenderBO update(Long id, GenderBO genderBO) {
        genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found gender with id " + id));
        GenderBO newGender = new GenderBO();
        newGender.setDescription(genderBO.getDescription());
        return this.genderMapper.genderDEtoBO(genderRepository.save(genderMapper.genderBOtoDE(newGender)));
    }

    public void deleteOneById(Long id) {
        genderRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found gender with id " + id));
        genderRepository.delete(genderRepository.findById(id).get());
    }


}

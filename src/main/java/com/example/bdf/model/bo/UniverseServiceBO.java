package com.example.bdf.model.bo;

import com.example.bdf.exception.NotFoundException;
import com.example.bdf.model.mapper.UniverseMapper;
import com.example.bdf.repository.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniverseServiceBO {

    private final UniverseRepository universeRepository;

    private final UniverseMapper universeMapper;

    @Autowired
    public UniverseServiceBO(UniverseRepository universeRepository, UniverseMapper universeMapper) {
        this.universeRepository = universeRepository;
        this.universeMapper = universeMapper;
    }

    public UniverseBO getUniverseByDescription(String descriptionUniverse) {
        return universeMapper.universeDEtoBO(universeRepository.getUniverseByDescription(descriptionUniverse));
    }

    public List<UniverseBO> getGenders() {
        return universeRepository.findAll()
                .stream()
                .map(this.universeMapper::universeDEtoBO)
                .collect(Collectors.toList());
    }

    public UniverseBO create(UniverseBO universe){
        return this.universeMapper.universeDEtoBO(universeRepository.save(universeMapper.universeBOtoDE(universe)));
    }

    public UniverseBO findById(Long id)  {
        universeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found universe with id " + id));
        return this.universeMapper.universeDEtoBO(universeRepository.findByIdEquals(id));
    }

    public UniverseBO update(Long id, UniverseBO universeBO) {
        universeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found universe with id " + id));
        UniverseBO newUniverse = new UniverseBO();
        newUniverse.setDescription(universeBO.getDescription());
        return this.universeMapper.universeDEtoBO(universeRepository.save(universeMapper.universeBOtoDE(newUniverse)));
    }

    public void deleteOneById(Long id) {
        universeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found universe with id " + id));
        universeRepository.delete(universeRepository.findById(id).get());
    }

}

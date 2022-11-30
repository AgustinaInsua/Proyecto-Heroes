package com.example.bdf.model.bo;

import com.example.bdf.model.mapper.TypeMapper;

import com.example.bdf.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceBO {

    private final TypeRepository typeRepository;

    private final TypeMapper typeMapper;


    @Autowired
    public TypeServiceBO(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    public TypeBO getTypeByDescription(String descriptionType) {
        return typeMapper.typeDEtoBO(typeRepository.getTypeByDescription(descriptionType));
    }

}

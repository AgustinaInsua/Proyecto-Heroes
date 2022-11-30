package com.example.bdf.service.imp;

import com.example.bdf.model.entity.TypeDE;
import com.example.bdf.service.interfaces.TypeService;

public class TypeServiceImp implements TypeService {

    @Override
    public TypeDE getTypeDEByCode(String codeType) {
        TypeDE typeDE = new TypeDE();
        typeDE.setCode(codeType);
        return typeDE;
    }
}

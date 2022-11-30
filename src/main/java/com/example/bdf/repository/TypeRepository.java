package com.example.bdf.repository;

import com.example.bdf.model.entity.TypeDE;
import com.example.bdf.model.entity.UniverseDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeDE, Long> {

    public TypeDE getTypeByDescription(String descriptionType);

}

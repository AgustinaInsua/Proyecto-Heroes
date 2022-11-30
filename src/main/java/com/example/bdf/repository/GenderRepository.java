package com.example.bdf.repository;

import com.example.bdf.model.entity.GenderDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderDE, Long> {

    public GenderDE getGenderByDescription(String descriptionGender);

    GenderDE findByIdEquals(Long id);
}

package com.example.bdf.repository;

import com.example.bdf.model.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

    public HeroEntity findByIdEquals(Long id);

    public List<HeroEntity> findByUniverse_Description(String name);

    public HeroEntity findByName(String name);

    @Query (value = "SELECT c FROM hero c WHERE (:universeDescription is null or c.universe.description =:universeDescription) and (:genderDescription is null  or c.gender.description =: genderDescription)",
    nativeQuery = true)
    List<HeroEntity> findByUniverseAndGender(@Param("universeDescription") String universe, @Param("genderDescription") String genderDescription);

}
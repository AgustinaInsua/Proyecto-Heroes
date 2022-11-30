package com.example.bdf.repository;

import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.controller.dto.UniverseDTO;
import com.example.bdf.model.bo.UniverseBO;
import com.example.bdf.model.entity.HeroEntity;
import com.example.bdf.model.entity.UniverseDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniverseRepository extends JpaRepository<UniverseDE, Long> {

 //   public List<UniverseDE> findByIdEquals(Long id);

  //  @Query("select e.name from heroes e, universe u where e.id=u.id and u.name =: name")

  //  public UniverseDE findByName(String name);

 //   public List<HeroEntity>();

      public UniverseDE getUniverseByDescription(String descriptionUniverse);

    UniverseDE findByIdEquals(Long id);
}

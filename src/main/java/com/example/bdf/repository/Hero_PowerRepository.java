package com.example.bdf.repository;

import com.example.bdf.model.entity.Hero_PowerDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hero_PowerRepository extends JpaRepository<Hero_PowerDE, Long>{


}

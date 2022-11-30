package com.example.bdf.repository;

import com.example.bdf.model.entity.PowerDE;
import com.example.bdf.model.entity.TypeDE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepository extends JpaRepository<PowerDE, Long> {

    public PowerDE getPowerByName(String Name);

}

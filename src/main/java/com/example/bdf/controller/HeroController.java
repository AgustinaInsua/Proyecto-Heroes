package com.example.bdf.controller;

import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.controller.dto.Hero_PowerDTO;
import com.example.bdf.service.imp.HeroServiceImp;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController implements HeroControllerSwagger {


    private final HeroServiceImp heroServiceImp;

    @Autowired
    public HeroController(HeroServiceImp heroServiceImp) {
        this.heroServiceImp = heroServiceImp;
    }

    @GetMapping()
    public List<HeroDTO> getHeroes() {
        return heroServiceImp.getHeroes();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getFindById(@PathVariable @Valid Long id) {
        return new ResponseEntity<>(heroServiceImp.findById(id), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public List<HeroDTO> getAllHeroes(@RequestParam(value = "universe") String universe) {
        return heroServiceImp.getHeroesByUniverse(universe);
    }

    @PostMapping()
    public ResponseEntity createHero(@RequestBody HeroDTO hero) {
      return new ResponseEntity<>(heroServiceImp.create(hero), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @SneakyThrows
    public ResponseEntity deleteHero(@PathVariable @Valid Long id) {
        heroServiceImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<HeroDTO> updateHero(@Valid @RequestBody HeroDTO newHero, @Valid @PathVariable Long id) {
        return new ResponseEntity<>(heroServiceImp.updateHero(id, newHero), HttpStatus.OK);
    }

}
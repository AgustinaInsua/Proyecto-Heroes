package com.example.bdf.controller;

import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.controller.dto.HeroDTO;
import com.example.bdf.service.imp.GenderServiceImp;
import com.example.bdf.service.imp.HeroServiceImp;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/genders")
public class GenderController {

    private final GenderServiceImp genderServiceImp;

    @Autowired
    public GenderController(GenderServiceImp genderServiceImp) {
        this.genderServiceImp = genderServiceImp;
    }

    @GetMapping()
    public List<GenderDTO> getGenders() {
        return genderServiceImp.getGender();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> getFindById(@PathVariable @Valid Long id) {
        return new ResponseEntity<>(genderServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody GenderDTO gender) {
        return new ResponseEntity<>(genderServiceImp.create(gender), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @SneakyThrows
    public ResponseEntity delete(@PathVariable @Valid Long id) {
        genderServiceImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<GenderDTO> updateGender(@Valid @RequestBody GenderDTO newGender, @Valid @PathVariable Long id) {
        return new ResponseEntity<>(genderServiceImp.update(id, newGender), HttpStatus.OK);
    }

}

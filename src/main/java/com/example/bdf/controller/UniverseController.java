package com.example.bdf.controller;

import com.example.bdf.controller.dto.GenderDTO;
import com.example.bdf.controller.dto.UniverseDTO;
import com.example.bdf.service.imp.UniverseServiceImp;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/universe")
public class UniverseController {

    private final UniverseServiceImp universeServiceImp;

    @Autowired
    public UniverseController(UniverseServiceImp universeServiceImp) {
        this.universeServiceImp = universeServiceImp;
    }

    @GetMapping()
    public List<UniverseDTO> getUniverse() {
        return universeServiceImp.getUniverse();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<UniverseDTO> getFindById(@PathVariable @Valid Long id) {
        return new ResponseEntity<>(universeServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody UniverseDTO universe) {
        return new ResponseEntity<>(universeServiceImp.create(universe), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @SneakyThrows
    public ResponseEntity delete(@PathVariable @Valid Long id) {
        universeServiceImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<UniverseDTO> updateUniverse(@Valid @RequestBody UniverseDTO newUniverse, @Valid @PathVariable Long id) {
        return new ResponseEntity<>(universeServiceImp.update(id, newUniverse), HttpStatus.OK);
    }
}

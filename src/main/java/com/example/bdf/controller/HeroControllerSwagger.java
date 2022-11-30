package com.example.bdf.controller;

import com.example.bdf.controller.dto.HeroDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface HeroControllerSwagger {


    @ApiOperation(value = "getHeroes", notes = "displays a list of all heroes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get list heroes successful."),
            @ApiResponse(code = 204, message = "No Content. There is not heroes."),
            @ApiResponse(code = 500, message = "System internal error ")
    })
    public List<HeroDTO> getHeroes();


    @ApiOperation(value = "getFindById", notes = "search for a hero according to his id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero found."),
            @ApiResponse(code = 404, message = "Not found. Hero not found with that id."),
            @ApiResponse(code = 400, message = "Bad request. Error in parameters."),
            @ApiResponse(code = 500, message = "System internal error.")
    })
    public ResponseEntity<HeroDTO> getFindById(@PathVariable @Valid Long id);


    @ApiOperation(value = "createHero", notes = "create a new heroe")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Hero created successful"),
            @ApiResponse(code = 400, message = "Bad Request. Hero already exist, or error in arguments."),
            @ApiResponse(code = 500, message = "System internal error ")
    })
    public ResponseEntity createHero(@RequestBody @Valid HeroDTO heroe);


    @ApiOperation(value = "deleteHero", notes = "delete a hero according to his id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero found and deleted."),
            @ApiResponse(code = 404, message = "Not found. Hero not found with that id."),
            @ApiResponse(code = 400, message = "Bad request. Error in parameters."),
            @ApiResponse(code = 500, message = "System internal error.")
    })
    public ResponseEntity deleteHero(@PathVariable @Valid Long id);


    @ApiOperation(value = "updateHero", notes = "update a hero according to his id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero found and updated."),
            @ApiResponse(code = 404, message = "Not found. Hero not found with that id."),
            @ApiResponse(code = 400, message = "Bad request. Error in parameters."),
            @ApiResponse(code = 500, message = "System internal error.")
    })
    public ResponseEntity<HeroDTO> updateHero(@Valid @RequestBody HeroDTO newHero, @Valid @PathVariable Long id);

}

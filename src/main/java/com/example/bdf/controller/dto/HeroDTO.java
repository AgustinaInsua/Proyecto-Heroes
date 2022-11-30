package com.example.bdf.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ApiModel (value= "HeroDTO", description = "It is used to expose the data")
public class HeroDTO {

    private Long id;

//    @NotEmpty(message = "field cannot be null or empty")
    private String name;

    private String city;

    private String enemy;

    private String partner;

    private String alterEgo;

    private String descriptionUniverse;

    private String descriptionType;

    private String descriptionGender;

    private List<String> powers;

    private List<String> weaknesses;
}

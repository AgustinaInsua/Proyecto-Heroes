package com.example.bdf.model.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class PartnerBO {

    private Long id;

    private String name;

}

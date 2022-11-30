package com.example.bdf.controller.dto;

import com.example.bdf.exception.CodeError;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ErrorDTO {

    private String message;
    private CodeError code;

}

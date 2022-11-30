package com.example.bdf.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class ExternalServiceException extends Exception {

    public ExternalServiceException(String message) {
        super("News not exist");
    }

}

package com.example.bdf.exception;

import com.example.bdf.controller.dto.ErrorDTO;
import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@ApiModel("used for exceptions")
@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> argumentExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuilder errorMessage = getErrorMessage(result);
        ErrorDTO error = ErrorDTO.builder().message(errorMessage.toString()).code(CodeError.C400).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private StringBuilder getErrorMessage(BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getDefaultMessage()));
        return errorMessage;
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException ex, WebRequest request) {
        ErrorDTO error = ErrorDTO.builder().message(ex.getMessage()).code(CodeError.C404).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorDTO> alreadyExistException(BadRequestException e) {
        ErrorDTO error = ErrorDTO.builder().message(e.getMessage()).code(CodeError.C400).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ExternalServiceException.class)
    public ResponseEntity<ErrorDTO> externalExceptionHandler(ExternalServiceException e) {
        ErrorDTO error = ErrorDTO.builder().message(e.getMessage()).code(CodeError.C500).build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

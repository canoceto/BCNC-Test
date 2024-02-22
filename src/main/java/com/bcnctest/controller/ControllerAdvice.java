package com.bcnctest.controller;

import com.bcnctest.dto.ErrorDTO;
import com.bcnctest.exception.NoAlbumException;
import com.bcnctest.shared.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder().code(Constant.ERROR_500).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoAlbumException.class)
    ResponseEntity<ErrorDTO> runtimeExceptionHandler(NoAlbumException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).message(ex.getMsg()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    ResponseEntity<ErrorDTO> runtimeExceptionHandler(NoResourceFoundException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder().code(Constant.ERROR_404).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ErrorDTO> runtimeExceptionHandler(Exception ex) {
        ErrorDTO errorDTO = ErrorDTO.builder().code(Constant.ERROR_500).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

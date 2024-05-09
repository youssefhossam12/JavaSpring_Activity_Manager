package com.example.activities.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Log4j2
public class RestExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotfound(ResourceNotFoundException e, WebRequest req){
        log.warn("Resource not found", String.format("error:%s, req:%s", e.getMessage(),req));
        return ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message("Not found")
                .description(e.getMessage())
                .tstamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage resourceAlreadyExist(ResourceAlreadyExistsException e, WebRequest req){
        log.warn("Resource Already Exists", String.format("error:%s, req:%s", e.getMessage(),req));
        return ErrorMessage.builder()
                .statusCode(HttpStatus.CONFLICT.value())
                .message("Conflict")
                .description(e.getMessage())
                .tstamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleServerError(Exception e){
        log.error("Server error", e);
        return ErrorMessage.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .description("see log")
                .tstamp(LocalDateTime.now())
                .message("Server error")
                .build();
    }

}

package com.appointment.api.controller;

import com.appointment.api.exception.DomainException;
import com.appointment.api.exception.ExceptionMessage;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.error.ErrorResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DomainException.class)
    public ErrorResponse domainException(DomainException ex){
        ExceptionMessage exceptionMessage = AnnotationUtils.findAnnotation(ex.getClass(), ExceptionMessage.class);
        return ErrorResponse.builder()
                .responseCode(exceptionMessage.responseCode())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse error(Exception ex){
        return ErrorResponse.builder()
                .responseCode(ResponseCode.UNDEFINED_ERROR)
                .build();
    }


}

package com.pool.casandra.config.exception;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pool.casandra.model.exception.CustomErrorResponse;
import com.pool.casandra.model.exception.RecordNotFoundException;

@Configuration
@RestControllerAdvice
public class GlobalExceptionConfiguration {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(RecordNotFoundException error) {
        String errorCode = HttpStatus.NOT_FOUND.toString();
        Integer status = HttpStatus.NOT_FOUND.value();

        return commonException(error.getMessage(), errorCode, status, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvocationTargetException.class)
    public ResponseEntity<CustomErrorResponse> handleInvocationTargetException(InvocationTargetException error) {
        String errorCode = HttpStatus.NOT_FOUND.toString();
        Integer status = HttpStatus.NOT_FOUND.value();

        return commonException(error.getMessage(), errorCode, status, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<CustomErrorResponse> commonException(String error, String errorCode,
            Integer status, HttpStatus notFound) {
        return new ResponseEntity<CustomErrorResponse>(new CustomErrorResponse().setErrorCode(errorCode)
                .setErrorMsg(error).setStatus(status).setTimestamp(new Date(System.currentTimeMillis())),
                notFound);
    }

}

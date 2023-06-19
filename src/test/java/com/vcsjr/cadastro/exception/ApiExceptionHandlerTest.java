package com.vcsjr.cadastro.exception;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiExceptionHandlerTest {

    private ApiExceptionHandler apiExceptionHandler = new ApiExceptionHandler();

    @Test
    void testHandleIllegalArgumentException() {
        String errorMessage = "Invalid argument";
        IllegalArgumentException exception = new IllegalArgumentException(errorMessage);

        ResponseEntity<String> response = apiExceptionHandler.handleIllegalArgumentException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }

    @Test
    void handleConstraintViolationException() {
        ConstraintViolationException exception = new ConstraintViolationException(Set.of());
        ResponseEntity<String> responseEntity = apiExceptionHandler.handleHttpClientError(exception);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("", responseEntity.getBody());
    }
}

package com.yagudza.washMachineHandler.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final String NO_PROGRAM = "There is no such program";

    @ExceptionHandler (ProgramNotExistsException.class)
    public ResponseEntity<String> stateNotFound() {
        return new ResponseEntity<>(NO_PROGRAM, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}

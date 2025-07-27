package com.example.demo.advisor;

import com.example.demo.exception.NotFoundException;
import com.example.demo.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    public ResponseEntity handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity(new StandardResponse(404,"Error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}

package com.app_manager.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app_manager.user.UserNotFoundException;
import com.app_manager.util.CustomResponse;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<?> userNotFoundHandler(UserNotFoundException exception) {

        logger.error(exception.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse(exception.toString()));
    }
}

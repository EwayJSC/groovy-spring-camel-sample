package com.eway.event_hub.controller

import io.x10.commons.spring.exception.SystemError
import io.x10.commons.spring.exception.SystemException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@RestController
class ExceptionsHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SystemException.class)
    final ResponseEntity<SystemError> ewayException(SystemException ex, WebRequest request) {
        return new ResponseEntity<SystemError>(new SystemError.Builder(ex.getCode())
            .details(ex.getDetailMessage())
            .fromPath(request.getContextPath())
            .withMessage(ex.getUserMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @ExceptionHandler(Exception.class)
    final ResponseEntity<SystemError> exception(Exception ex, WebRequest request) {
        return new ResponseEntity<SystemError>(new SystemError.Builder(999)
            .details(ex.getMessage())
            .fromPath(request.getContextPath())
            .withMessage("Unknown exception").build(), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

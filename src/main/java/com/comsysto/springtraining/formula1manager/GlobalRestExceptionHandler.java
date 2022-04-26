package com.comsysto.springtraining.formula1manager;

import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalRestExceptionHandler {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler
    @ResponseBody
    public Object handleException(MethodArgumentNotValidException exception) {
        return Set.of(exception.getBindingResult().getAllErrors());
    }
}

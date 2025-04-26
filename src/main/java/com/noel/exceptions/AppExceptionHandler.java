package com.noel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus
public class AppExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ErrorMessage handleInvalidParameters(UnauthorizedException e) {
        return new ErrorMessage(401, "Unauthorized");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidParameters(MethodArgumentNotValidException e) {
        return new ErrorMessage(400, e.getAllErrors().get(0).getDefaultMessage());
    }
}

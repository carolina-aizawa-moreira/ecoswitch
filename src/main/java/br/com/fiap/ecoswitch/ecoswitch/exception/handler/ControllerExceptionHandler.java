package br.com.fiap.ecoswitch.ecoswitch.exception.handler;

import br.com.fiap.ecoswitch.ecoswitch.exception.BadRequestException;
import br.com.fiap.ecoswitch.ecoswitch.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, String> NotFoundException(NotFoundException e){
         Map<String, String> errorMap = new HashMap<>();
         String message = e.getMessage();

         errorMap.put("message", message);

         return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, String> NotFoundException(BadRequestException e){
        Map<String, String> errorMap = new HashMap<>();
        String message = e.getMessage();

        errorMap.put("message", message);

        return errorMap;
    }

}

package com.example.gacha;

import com.example.gacha.Exception.NotEnoughException;
import com.example.gacha.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NotEnoughException.class})
    public Map<String, Object> handleNotEnoughException(NotEnoughException e, WebRequest webRequest){
        log.error("Error", e.getMessage());
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", "コインが足りません。");
        return errors;
    }
}

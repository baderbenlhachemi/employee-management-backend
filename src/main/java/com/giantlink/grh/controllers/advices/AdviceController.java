package com.giantlink.grh.controllers.advices;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceController {

        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        @ExceptionHandler(NotFoundException.class)
        public Map<String, Object> handleNotFoundException(NotFoundException ex) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", ex.getMessage());
            return map;
        }

        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ExceptionHandler(AlreadyExistsException.class)
        public Map<String, Object> handleAlreadyExistsException(AlreadyExistsException ex) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", ex.getMessage());
            return map;
        }

        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, Object> handleResourceNotFoundException(MethodArgumentNotValidException ex) {
            Map<String, Object> map = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(
                    error -> map.put(error.getField(), error.getDefaultMessage())
            );
            return map;
        }

        //IOException
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ExceptionHandler(IOException.class)
        public Map<String, Object> handleIOException(IOException ex) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", ex.getMessage());
            return map;
        }

        //MalformedURLException
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MalformedURLException.class)
        public Map<String, Object> handleMalformedURLException(MalformedURLException ex) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", ex.getMessage());
            return map;
        }

}

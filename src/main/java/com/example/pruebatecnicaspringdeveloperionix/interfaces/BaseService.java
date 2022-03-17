package com.example.pruebatecnicaspringdeveloperionix.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Allow preparing exceptions
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@RequiredArgsConstructor
public abstract class BaseService {

    protected <T> ResponseEntity<T> setResponse(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }
}

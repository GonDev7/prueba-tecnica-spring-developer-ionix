package com.example.pruebatecnicaspringdeveloperionix.interfaces;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Allow preparing responses mappings
 * @version 1.0.0 - 28 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 28 Mar 2022
 */
@RequiredArgsConstructor
public abstract class MapResponse {

    protected <K, V> Map<K, V> setMapResponse(K key, V value) {
        Map<K, V> response = new HashMap<>();
        response.put(key,value);
        return response;
    }
}
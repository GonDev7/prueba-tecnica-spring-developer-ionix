package com.example.pruebatecnicaspringdeveloperionix.domain;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;

/**
 * Create user repository
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@FunctionalInterface
public interface CreateUserRepository {

    UserDto createUser(UserDto user);
}

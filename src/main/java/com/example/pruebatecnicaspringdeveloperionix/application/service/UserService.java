package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;

import java.util.List;

/**
 * Interface user services
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
public interface UserService {

    UserDto createUser(UserDto user);

    List<UserDto> getUsers();

    UserDto findByEmail(String email);
}

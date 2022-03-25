package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.CreateUserRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetListUsersRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetUserByEmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements interface UserService
 * @version 1.0.1 - 25 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService {

    private final CreateUserRepository createUserRepository;
    private final GetListUsersRepository getListUsersRepository;
    private final GetUserByEmailRepository getUserByEmailRepository;

    @Override
    public UserDto createUser(UserDto user) {
        return createUserRepository.createUser(user);
    }

    @Override
    public List<UserDto> getUsers() {
        return getListUsersRepository.listUsers();
    }

    @Override
    public UserDto findByEmail(String email) {
        return getUserByEmailRepository.getUserByEmail(email);
    }
}

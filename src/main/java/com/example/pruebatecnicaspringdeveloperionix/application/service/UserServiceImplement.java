package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import com.example.pruebatecnicaspringdeveloperionix.domain.CreateUserRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetListUsersRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetUserByEmailRepository;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements interface UserService
 * @version 1.0.0 - 17 Mar 2022
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
        UserDto userExits = getUserByEmailRepository.getUserByEmail(user.getEmail());
        if (userExits == null) {
            return createUserRepository.createUser(user);
        } else {
            return userExits;
        }
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

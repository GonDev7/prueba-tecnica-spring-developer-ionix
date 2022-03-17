package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    User findByEmail(String email);
}

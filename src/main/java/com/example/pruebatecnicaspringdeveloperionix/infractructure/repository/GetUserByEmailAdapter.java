package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetUserByEmailRepository;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping.GetUserByEmailRepositoryMapping;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Get User By Email Adapter
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Repository
@RequiredArgsConstructor
public class GetUserByEmailAdapter implements GetUserByEmailRepository {

    private final UserRepository userRepository;

    private User userByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return GetUserByEmailRepositoryMapping.builder().build().getResponse(userByEmail(email));
    }
}

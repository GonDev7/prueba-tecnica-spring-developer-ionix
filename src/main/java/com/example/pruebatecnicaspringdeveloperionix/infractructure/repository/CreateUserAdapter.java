package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import com.example.pruebatecnicaspringdeveloperionix.domain.CreateUserRepository;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping.CreateUserRepositoryMapping;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Create user Adapter
 * @version 1.0.1 - 30 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Repository
@RequiredArgsConstructor
public class CreateUserAdapter implements CreateUserRepository {

    private final UserRepository userRepository;

    private User buildUserEntity(UserDto user) {
        return userRepository.save(User.builder()
                .name(user.getName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build());
    }

    @Override
    public UserDto createUser(UserDto user) {
        CreateUserRepositoryMapping mapper = CreateUserRepositoryMapping.builder().build();
        return mapper.getResponse(buildUserEntity(user));
    }
}

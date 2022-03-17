package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import lombok.Builder;

/**
 * Get User By Email mapping response
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Builder
public class GetUserByEmailRepositoryMapping implements RepositoryAdapter<User, UserDto> {

    @Override
    public User getRequest(Object... parameters) {
        return null;
    }

    @Override
    public UserDto getResponse(Object... parameters) {
        User userService = (User) parameters[0];
        if (userService != null) {
            return UserDto.builder()
                    .name(userService.getName())
                    .userName(userService.getUserName())
                    .email(userService.getEmail())
                    .phone(userService.getPhone())
                    .build();
        }
        return null;
    }
}

package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import lombok.Builder;

/**
 * Create user mapping response
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Builder
public class CreateUserRepositoryMapping implements RepositoryAdapter<Object, UserDto> {

    @Override
    public Object getRequest(Object... parameters) {
        return null;
    }

    @Override
    public UserDto getResponse(Object... parameters) {
        User responseService = (User) parameters[0];
        return UserDto.builder()
                .name(responseService.getName())
                .userName(responseService.getUserName())
                .email(responseService.getEmail())
                .phone(responseService.getPhone())
                .build();
    }
}

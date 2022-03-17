package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ListUsers;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import lombok.Builder;

import java.util.List;

/**
 * Get list users mapping response
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Builder
public class GetListUsersRepositoryMapping implements RepositoryAdapter<Object, List<UserDto>> {

    @Override
    public Object getRequest(Object... parameters) {
        return null;
    }

    @Override
    public List<UserDto> getResponse(Object... parameters) {
        ListUsers listUsers = (ListUsers) parameters[0];
        return listUsers.getUsers();
    }
}

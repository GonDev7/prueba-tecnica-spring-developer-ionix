package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ListUsers;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetListUsersRepository;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping.GetListUsersRepositoryMapping;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Get List Users Adapter
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Repository
@RequiredArgsConstructor
public class GetListUsersAdapter implements GetListUsersRepository {

    private final UserRepository userRepository;

    private ListUsers getUsers() {
        ListUsers response = new ListUsers();
        List<UserDto> usersDto =  userRepository.findAll().stream().map(users -> {
            UserDto userDto = new UserDto();
            userDto.setName(users.getName());
            userDto.setUserName(users.getUserName());
            userDto.setEmail(users.getEmail());
            userDto.setPhone(users.getPhone());
            return userDto;
        }).collect(Collectors.toList());
        response.setUsers(usersDto);
        return response;
    }

    @Override
    public List<UserDto> listUsers() {
        return GetListUsersRepositoryMapping.builder().build().getResponse(getUsers());
    }
}

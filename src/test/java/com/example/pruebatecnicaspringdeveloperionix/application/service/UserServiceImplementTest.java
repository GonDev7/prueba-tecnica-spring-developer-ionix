package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.mocks.UserMock;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.CreateUserRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetListUsersRepository;
import com.example.pruebatecnicaspringdeveloperionix.domain.GetUserByEmailRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests method for User Controller
 * @version 1.1.0 - 30 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 28 Mar 2022
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplementTest {

    @InjectMocks
    UserServiceImplement userServiceImplement;
    @Mock
    CreateUserRepository createUserRepository;
    @Mock
    GetListUsersRepository getListUsersRepository;
    @Mock
    GetUserByEmailRepository getUserByEmailRepository;

    @Test
    void createUserTest() {
        when(createUserRepository.createUser(any())).thenReturn(UserMock.buildUserDto());
        UserDto newUser = userServiceImplement.createUser(new UserDto());

        assertNotNull(newUser);
        assertEquals(UserDto.class, newUser.getClass());
    }

    @Test
    void getUsersTest() {
        when(getListUsersRepository.listUsers()).thenReturn(UserMock.buildListUserDto());
        List<UserDto> userDtoList = userServiceImplement.getUsers();

        assertNotNull(userDtoList);
        assertEquals(UserMock.buildListUserDto(), userDtoList);
        assertEquals(new ArrayList<>().add(UserMock.buildListUserDto()), userDtoList.size() >= 1);
    }

    @Test
    void getUsersEmptyTest() {
        when(getListUsersRepository.listUsers()).thenReturn(Collections.emptyList());
        List<UserDto> userDtoList = userServiceImplement.getUsers();

        assertNotNull(userDtoList);
        assertEquals(new ArrayList<>(), userDtoList);
    }

    @Test
    void findByEmailTest() {
        when(getUserByEmailRepository.getUserByEmail(anyString())).thenReturn(UserMock.buildUserDto());
        UserDto userFind = userServiceImplement.findByEmail(UserMock.EMAIL);

        assertNotNull(userFind);
        assertEquals(userFind.getClass(), UserDto.class);
    }

    @Test
    void findByEmailNotFoundTest() {
        when(getUserByEmailRepository.getUserByEmail(anyString())).thenReturn(UserMock.buildUserDtoNotFound());
        UserDto userFind = userServiceImplement.findByEmail(UserMock.EMAIL);

        assertNull(userFind);
    }
}
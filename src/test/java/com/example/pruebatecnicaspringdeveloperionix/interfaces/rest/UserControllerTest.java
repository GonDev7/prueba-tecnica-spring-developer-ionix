package com.example.pruebatecnicaspringdeveloperionix.interfaces.rest;

import com.example.pruebatecnicaspringdeveloperionix.mocks.UserMock;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests method for User Controller
 * @version 1.1.0 - 28 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 25 Mar 2022
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    @Test
    void createUserTest() {
        when(userService.createUser(any())).thenReturn(UserMock.buildUserDto());
        ResponseEntity<Object> newUser = userController.createUser(new UserDto());

        assertNotNull(newUser);
        assertEquals(HttpStatus.CREATED, newUser.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_CREATED, newUser.getStatusCodeValue());
        assertEquals(UserMock.buildUserDto(), newUser.getBody());
        assertEquals(UserDto.class, Objects.requireNonNull(newUser.getBody()).getClass());
        assertEquals(ResponseEntity.class, newUser.getClass());
    }

    @Test
    void getUsersTest() {
        when(userService.getUsers()).thenReturn(UserMock.buildListUserDto());
        ResponseEntity<List<UserDto>> userDtoList = userController.getUsers();

        assertNotNull(userDtoList);
        assertEquals(HttpStatus.OK, userDtoList.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_OK, userDtoList.getStatusCodeValue());
        assertEquals(UserMock.buildListUserDto(), userDtoList.getBody());
        assertEquals(ResponseEntity.class, userDtoList.getClass());
    }

    @Test
    void getUsersEmptyTest() {
        when(userService.getUsers()).thenReturn(Collections.emptyList());
        ResponseEntity<List<UserDto>> userDtoList = userController.getUsers();

        assertNotNull(userDtoList);
        assertEquals(UserMock.EMPTY_INT, Objects.requireNonNull(userDtoList.getBody()).size());
        assertEquals(new ArrayList<>(), userDtoList.getBody());
        assertEquals(HttpStatus.OK, userDtoList.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_OK, userDtoList.getStatusCodeValue());
        assertEquals(ResponseEntity.class, userDtoList.getClass());
    }

    @Test
    void getUserByEmailTest() {
        when(userService.findByEmail(anyString())).thenReturn(UserMock.buildUserDto());
        ResponseEntity<Object> userFind = userController.getUserByEmail(UserMock.EMAIL);

        assertNotNull(userFind);
        assertEquals(HttpStatus.OK, userFind.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_OK, userFind.getStatusCodeValue());
        assertEquals(UserMock.buildUserDto(), userFind.getBody());
        assertEquals(UserDto.class, Objects.requireNonNull(userFind.getBody()).getClass());
        assertEquals(ResponseEntity.class, userFind.getClass());
    }

    @Test
    void getUserByEmailNotFound() {
        when(userService.findByEmail(anyString())).thenReturn(UserMock.buildUserDtoNotFound());
        ResponseEntity<Object> userFind = userController.getUserByEmail(UserMock.EMAIL);

        assertNotNull(userFind);
        assertEquals(HttpStatus.OK, userFind.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_OK, userFind.getStatusCodeValue());
        assertEquals(UserMock.userNotFoundResponse(), userFind.getBody());
        assertEquals(ResponseEntity.class, userFind.getClass());
    }
}
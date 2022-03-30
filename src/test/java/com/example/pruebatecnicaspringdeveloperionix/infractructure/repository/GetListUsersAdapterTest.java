package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.mocks.UserMock;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
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
 * Unit tests method for List Users Adapter
 * @version 1.0.0 - 30 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 30 Mar 2022
 */
@ExtendWith(MockitoExtension.class)
class GetListUsersAdapterTest {

    @InjectMocks
    GetListUsersAdapter getListUsersAdapter;
    @Mock
    UserRepository userRepository;

    @Test
    void listUsersTest() {
        when(userRepository.findAll()).thenReturn(UserMock.buildListUser());
        List<UserDto> userDtoList = getListUsersAdapter.listUsers();

        assertNotNull(userDtoList);
        assertEquals(UserMock.buildListUserDto(), userDtoList);
        assertEquals(new ArrayList<>().add(UserMock.buildListUserDto()), userDtoList.size() >= 1);
    }

    @Test
    void emptyListUsersTest() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<UserDto> userDtoList = getListUsersAdapter.listUsers();

        assertNotNull(userDtoList);
        assertEquals(new ArrayList<>(), userDtoList);
    }
}
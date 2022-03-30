package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.mocks.UserMock;
import com.example.pruebatecnicaspringdeveloperionix.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests method for Create User Adapter
 * @version 1.0.0 - 30 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 30 Mar 2022
 */
@ExtendWith(MockitoExtension.class)
class CreateUserAdapterTest {

    @InjectMocks
    CreateUserAdapter createUserAdapter;
    @Mock
    UserRepository userRepository;

    @Test
    void createUserTest() {
        when(userRepository.save(any())).thenReturn(UserMock.buildUser());
        UserDto newUser = createUserAdapter.createUser(new UserDto());

        assertNotNull(newUser);
        assertEquals(UserDto.class, newUser.getClass());
    }
}
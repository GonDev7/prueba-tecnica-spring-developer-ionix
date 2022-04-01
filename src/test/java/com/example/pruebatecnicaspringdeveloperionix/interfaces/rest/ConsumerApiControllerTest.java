package com.example.pruebatecnicaspringdeveloperionix.interfaces.rest;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.application.service.ParameterEncryptionService;
import com.example.pruebatecnicaspringdeveloperionix.mocks.EncryptMock;
import com.example.pruebatecnicaspringdeveloperionix.mocks.UserMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests method for Consumer API controller test
 * @version 1.0.0 - 31 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 31 Mar 2022
 */
@ExtendWith(MockitoExtension.class)
class ConsumerApiControllerTest {

    @InjectMocks
    ConsumerApiController consumerApiController;
    @Mock
    ParameterEncryptionService parameterEncryptionService;

    @Test
    void parameterEncryptionTest() throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        when(parameterEncryptionService.parameterEncryption(anyString())).thenReturn(EncryptMock.buildParameterEncryptionResponseDto());
        ResponseEntity<Object> response = consumerApiController.parameterEncryption(EncryptMock.buildParamDto());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(UserMock.STATUS_CODE_OK, response.getStatusCodeValue());
        assertEquals(EncryptMock.buildParameterEncryptionResponseDto(), response.getBody());
        assertEquals(ParameterEncryptionResponseDto.class, Objects.requireNonNull(response.getBody()).getClass());
        assertEquals(ResponseEntity.class, response.getClass());
    }
}
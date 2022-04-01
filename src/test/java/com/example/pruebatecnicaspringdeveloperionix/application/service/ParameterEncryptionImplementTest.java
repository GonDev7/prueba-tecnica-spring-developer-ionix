package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.ParameterEncryptionRepository;
import com.example.pruebatecnicaspringdeveloperionix.mocks.EncryptMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests method for Parameter Encryption Implement Test
 * @version 1.0.0 - 01 Abr 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 01 Abr 2022
 */
@ExtendWith(MockitoExtension.class)
class ParameterEncryptionImplementTest {

    @InjectMocks
    ParameterEncryptionImplement parameterEncryptionImplement;
    @Mock
    ParameterEncryptionRepository parameterEncryptionRepository;

    @Test
    void parameterEncryptionTest() throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        when(parameterEncryptionRepository.parameterEncryption(anyString()))
                .thenReturn(EncryptMock.buildParameterEncryptionResponseDto());
        ParameterEncryptionResponseDto responseDto = parameterEncryptionImplement.parameterEncryption(EncryptMock.PARAM_TO_ECRIPTING);

        assertNotNull(responseDto);
        assertEquals(EncryptMock.RESPONSE_CODE, responseDto.getResponseCode());
        assertEquals(EncryptMock.RESPONSE_DESCRIPTION, responseDto.getDescription());
        assertEquals(EncryptMock.REGISTER_COUNT, responseDto.getResult().getRegisterCount());
        assertEquals(ParameterEncryptionResponseDto.class, responseDto.getClass());
    }
}
package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.client.ParameterEncryptionRestClient;
import com.example.pruebatecnicaspringdeveloperionix.mocks.EncryptMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests method for Parameter Encryption Adapter
 * @version 1.0.0 - 01 Abr 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 01 Abr 2022
 */
@ExtendWith(MockitoExtension.class)
class ParameterEncryptionAdapterTest {

    @InjectMocks
    ParameterEncryptionAdapter parameterEncryptionAdapter;
    @Mock
    ParameterEncryptionRestClient parameterEncryptionRestClient;

    @Test
    void parameterEncryptionTests() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        when(parameterEncryptionRestClient.parameterEncryption(anyString()))
                .thenReturn(EncryptMock.buildParameterEncryptionResponseService());
        ParameterEncryptionResponseDto responseService = parameterEncryptionAdapter.parameterEncryption(EncryptMock.PARAM_TO_ECRIPTING);

        assertNotNull(responseService);
        assertEquals(EncryptMock.RESPONSE_CODE, responseService.getResponseCode());
        assertEquals(EncryptMock.RESPONSE_DESCRIPTION, responseService.getDescription());
        assertEquals(EncryptMock.REGISTER_COUNT, responseService.getResult().getRegisterCount());
        assertEquals(ParameterEncryptionResponseDto.class, responseService.getClass());
    }
}
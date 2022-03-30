package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.ParameterEncryptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Implements interface Parameter Encryption
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Service
@AllArgsConstructor
public class ParameterEncryptionImplement implements ParameterEncryptionService {

    private final ParameterEncryptionRepository parameterEncryptionRepository;

    @Override
    public ParameterEncryptionResponseDto parameterEncryption(String value) throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        return parameterEncryptionRepository.parameterEncryption(value);
    }
}

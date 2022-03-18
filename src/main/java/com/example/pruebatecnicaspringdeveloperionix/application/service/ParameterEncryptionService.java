package com.example.pruebatecnicaspringdeveloperionix.application.service;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Parameter Encryption Service
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
public interface ParameterEncryptionService {

    ParameterEncryptionResponseDto parameterEncryption(String value) throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException;
}

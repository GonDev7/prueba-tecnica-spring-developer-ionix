package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.domain.ParameterEncryptionRepository;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.client.ParameterEncryptionRestClient;
import com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping.ParameterEncryptionRepositoryMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Parameter Encryption Adapter
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Repository
@RequiredArgsConstructor
public class ParameterEncryptionAdapter implements ParameterEncryptionRepository {

    private final ParameterEncryptionRestClient client;

    @Override
    public ParameterEncryptionResponseDto parameterEncryption(String value) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        return ParameterEncryptionRepositoryMapping.builder().build().getResponse(client.parameterEncryption(value));
    }
}

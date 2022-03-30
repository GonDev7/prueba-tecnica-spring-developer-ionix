package com.example.pruebatecnicaspringdeveloperionix.infractructure.client;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseService;
import com.example.pruebatecnicaspringdeveloperionix.shared.utils.UtilCommon;
import com.example.pruebatecnicaspringdeveloperionix.shared.constants.ConstantsProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Parameter Encryption Rest Client
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Component
@AllArgsConstructor
public class ParameterEncryptionRestClient {

    private final RestTemplate restTemplate;

    public ParameterEncryptionResponseService parameterEncryption(String value) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        String paramEncrypted = UtilCommon.encryptForDES(value);
        return restTemplate.getForObject(ConstantsProperties.URL_ENCRYPTION + paramEncrypted, ParameterEncryptionResponseService.class);
    }

}

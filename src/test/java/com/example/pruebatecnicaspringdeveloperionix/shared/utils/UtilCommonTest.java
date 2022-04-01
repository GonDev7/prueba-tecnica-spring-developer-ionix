package com.example.pruebatecnicaspringdeveloperionix.shared.utils;

import com.example.pruebatecnicaspringdeveloperionix.mocks.EncryptMock;
import com.example.pruebatecnicaspringdeveloperionix.shared.constants.ConstantsProperties;
import org.junit.jupiter.api.Test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class UtilCommonTest {

    @Test
    void encryptForDESTest() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(ConstantsProperties.KEY_ENCRYPTION.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key1 = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key1, sr);
        byte[] encryptedData = cipher.doFinal(EncryptMock.PARAM_TO_ECRIPTING.getBytes(StandardCharsets.UTF_8));
        String paramEncrypted = Base64.getEncoder().encodeToString(encryptedData);

        assertNotNull(paramEncrypted);
    }
}
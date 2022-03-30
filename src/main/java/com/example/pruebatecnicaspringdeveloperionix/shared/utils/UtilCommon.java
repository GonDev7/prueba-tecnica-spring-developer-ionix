package com.example.pruebatecnicaspringdeveloperionix.shared.utils;

import com.example.pruebatecnicaspringdeveloperionix.shared.constants.ConstantsProperties;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Class string utils
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
public class UtilCommon {

    /**
     * Allows to encrypt a text string in DES format
     * @param param text string to be encrypted
     * @return text string to encrypted
     */
    public static String encryptForDES(String param) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(ConstantsProperties.KEY_ENCRYPTION.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key1 = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key1, sr);
        byte[] encryptedData = cipher.doFinal(param.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedData);
    }
}

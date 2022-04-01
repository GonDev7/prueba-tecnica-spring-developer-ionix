package com.example.pruebatecnicaspringdeveloperionix.interfaces.rest;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParamDto;
import com.example.pruebatecnicaspringdeveloperionix.application.service.ParameterEncryptionService;
import com.example.pruebatecnicaspringdeveloperionix.interfaces.BaseService;
import com.example.pruebatecnicaspringdeveloperionix.shared.constants.ConstantsPath;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * End Points consumer api service
 * @version 1.0.1 - 31 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@RestController
@RequestMapping(value = ConstantsPath.BASE_PATH)
@RequiredArgsConstructor
public class ConsumerApiController extends BaseService {

    private final ParameterEncryptionService parameterEncryptionService;

    @PostMapping("/parameter-encryption")
    public ResponseEntity<Object> parameterEncryption(@RequestBody ParamDto param) throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        return setResponse(parameterEncryptionService.parameterEncryption(param.getParam()), HttpStatus.OK);
    }
}

package com.example.pruebatecnicaspringdeveloperionix.infractructure.repository.mapping;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseDto;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.ParameterEncryptionResponseService;
import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.RegisterCountDto;
import lombok.Builder;

/**
 * Parameter Encryption Repository mapping response
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Builder
public class ParameterEncryptionRepositoryMapping implements RepositoryAdapter<String, ParameterEncryptionResponseDto> {

    @Override
    public String getRequest(Object... parameters) {
        return null;
    }

    @Override
    public ParameterEncryptionResponseDto getResponse(Object... parameters) {
        ParameterEncryptionResponseService responseService = (ParameterEncryptionResponseService) parameters[0];
        return ParameterEncryptionResponseDto.builder()
                .responseCode(responseService.getResponseCode())
                .description(responseService.getDescription())
                .elapsedTime(null)
                .result(RegisterCountDto.builder().registerCount(responseService.getResult().getItems().size()).build())
                .build();
    }
}

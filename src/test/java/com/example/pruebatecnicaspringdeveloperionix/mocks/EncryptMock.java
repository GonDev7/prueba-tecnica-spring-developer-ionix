package com.example.pruebatecnicaspringdeveloperionix.mocks;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Create objects utils of Encrypt
 * @version 1.0.0 - 25 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 25 Mar 2022
 */
public class EncryptMock {

    public static final String PARAM_TO_ECRIPTING = "1-9";
    public static final String PARAM_ENCRIPTED = "JYBVdbYsiS4=";
    public static final String RESPONSE_CODE = "200";
    public static final String RESPONSE_DESCRIPTION = "OK";
    public static final Date ELAPSED_TIME = new Date();
    public static final Integer REGISTER_COUNT = 3;

    public static final String ITEM_NAME = "item";
    public static final String ITEM_NAME_2 = "item 2";
    public static final String ITEM_NAME_3 = "item 3";
    public static final String ITEM_EMAIL = "aaa@aa.com";
    public static final String ITEM_PHONE = "987654321";

    /**
     * Allow to create a Parameter Encryption Response DTO model
     * @return ParameterEncryptionResponseDto entity
     */
    public static ParameterEncryptionResponseDto buildParameterEncryptionResponseDto() {
        return ParameterEncryptionResponseDto.builder()
                .responseCode(RESPONSE_CODE)
                .description(RESPONSE_DESCRIPTION)
                .elapsedTime(ELAPSED_TIME)
                .result(RegisterCountDto.builder().registerCount(REGISTER_COUNT).build())
                .build();
    }

    public static ParameterEncryptionResponseService buildParameterEncryptionResponseService() {
        return ParameterEncryptionResponseService.builder()
                .responseCode(RESPONSE_CODE)
                .description(RESPONSE_DESCRIPTION)
                .elapsedTime(ELAPSED_TIME)
                .result(buildResultDto())
                .build();
    }

    public static ResultDto buildResultDto() {
        return ResultDto.builder()
                .items(buildListItemsResponseDto())
                .build();
    }

    public static List<ItemsResponseDto> buildListItemsResponseDto() {
        return Arrays.asList(
                ItemsResponseDto.builder()
                        .name(ITEM_NAME)
                    .detail(buildDetailResponseDto())
                    .build(),
                ItemsResponseDto.builder()
                        .name(ITEM_NAME_2)
                        .detail(buildDetailResponseDto())
                        .build(),
                ItemsResponseDto.builder()
                        .name(ITEM_NAME_3)
                        .detail(buildDetailResponseDto())
                        .build());
    }

    public static DetailResponseDto buildDetailResponseDto() {
        return DetailResponseDto.builder()
                .email(ITEM_EMAIL)
                .phoneNumber(ITEM_PHONE)
                .build();
    }

    /**
     * Allow to create a Param DTO model request
     * @return ParamDto entity
     */
    public static ParamDto buildParamDto() {
        return ParamDto.builder().param(PARAM_TO_ECRIPTING).build();
    }
}

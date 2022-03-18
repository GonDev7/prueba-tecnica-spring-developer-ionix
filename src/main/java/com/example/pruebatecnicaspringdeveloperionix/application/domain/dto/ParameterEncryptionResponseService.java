package com.example.pruebatecnicaspringdeveloperionix.application.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class for Data Transfer
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParameterEncryptionResponseService {

    private String responseCode;
    private String description;
    private Date elapsedTime;
    private ResultDto result;
}

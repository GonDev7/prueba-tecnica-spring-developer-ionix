package com.example.pruebatecnicaspringdeveloperionix.application.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for Data Transfer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long userId;
    private String name;
    @JsonProperty("user_name")
    private String userName;
    private String email;
    private String phone;
}

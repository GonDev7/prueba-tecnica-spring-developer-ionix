package com.example.pruebatecnicaspringdeveloperionix.mocks;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create objects utils of User model
 * @version 1.0.0 - 25 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 25 Mar 2022
 */
public class UserMock {

    public static final String NAME = "name";
    public static final String USER_NAME = "user name";
    public static final String EMAIL = "mail@mail.com";
    public static final String PHONE = "987654321";

    public static final Integer EMPTY_INT = 0;
    public static final String EMPTY_STRING = "";

    public static final Integer STATUS_CODE_OK = 200;
    public static final Integer STATUS_CODE_CREATED = 201;

    public static final String MAP_RESPONSE_KEY = "response";
    public static final String MAP_RESPONSE_VALUE_USER_EXISTED = "User exists";
    public static final String MAP_RESPONSE_VALUE_USER_NOT_FOUND = "User not found";

    /**
     * Allow create a User DTO model
     * @return UserDto entity
     */
    public static UserDto buildUserDto() {
        return UserDto.builder()
                .name(NAME)
                .userName(USER_NAME)
                .email(EMAIL)
                .phone(PHONE)
                .build();
    }

    /**
     * Allow create a User DTO model
     * @return UserDto entity
     */
    public static UserDto buildUserDtoNotFound() {
        return null;
    }

    /**
     * Allow create a list User DTO model
     * @return UserDto list entity
     */
    public static List<UserDto> buildListUserDto() {
        return List.of(UserDto.builder()
                .name(NAME)
                .userName(USER_NAME)
                .email(EMAIL)
                .phone(PHONE)
                .build());
    }

    /**
     * Allow to create an empty list
     * @return UserDto list entity
     */
    public static List<UserDto> buildEmptyListUserDto() {
        return Collections.emptyList();
    }

    /**
     * Allow to create a response Map for user exists
     * @return Map with message
     */
    public static Map<String, String> userExistsResponse() {
        Map<String, String> response = new HashMap<>();
        response.put(MAP_RESPONSE_KEY, MAP_RESPONSE_VALUE_USER_EXISTED);
        return response;
    }

    /**
     * Allow to create a response Map for user not found
     * @return Map with message
     */
    public static Map<String, String> userNotFoundResponse() {
        Map<String, String> response = new HashMap<>();
        response.put(MAP_RESPONSE_KEY, MAP_RESPONSE_VALUE_USER_NOT_FOUND);
        return response;
    }
}

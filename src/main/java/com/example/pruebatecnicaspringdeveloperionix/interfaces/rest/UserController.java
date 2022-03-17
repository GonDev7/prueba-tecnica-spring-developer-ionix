package com.example.pruebatecnicaspringdeveloperionix.interfaces.rest;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.dto.UserDto;
import com.example.pruebatecnicaspringdeveloperionix.application.service.UserService;
import com.example.pruebatecnicaspringdeveloperionix.interfaces.BaseService;
import com.example.pruebatecnicaspringdeveloperionix.shared.constants.ConstantsPath;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * End Points User service
 * @version 1.0.0 - 17 Mar 2022
 * @author Gonzalo Rojas - gonzalo.rojasmardones@gmail.com
 * @since 1.0.0 - 17 Mar 2022
 */
@RestController
@RequestMapping(value = ConstantsPath.BASE_PATH)
@RequiredArgsConstructor
public class UserController extends BaseService {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody UserDto user) {
        UserDto userFind = userService.findByEmail(user.getEmail());
        if (userFind != null) return setResponse("User exists", HttpStatus.OK);
        return setResponse(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return setResponse(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable("email") String email) {
        UserDto userFind = userService.findByEmail(email);
        if (userFind == null) return setResponse("User not found", HttpStatus.OK);
        return setResponse(userService.findByEmail(email), HttpStatus.OK);
    }
}

package com.example.pruebatecnicaspringdeveloperionix.interfaces.rest;

import com.example.pruebatecnicaspringdeveloperionix.application.domain.entity.User;
import com.example.pruebatecnicaspringdeveloperionix.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }
}

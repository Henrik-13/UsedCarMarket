package io.github.henrik13.usedcarmarket.controller;

import io.github.henrik13.usedcarmarket.dto.indto.LoginDto;
import io.github.henrik13.usedcarmarket.dto.indto.RegisterDto;
import io.github.henrik13.usedcarmarket.model.User;
import io.github.henrik13.usedcarmarket.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {
        if (userService.existsByUsername(registerDto.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        userService.createUser(user);

        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDto loginDto) {
        User user = new User();
        user.setUsername(loginDto.getUsername());
        user.setPassword(loginDto.getPassword());

        String token = userService.authenticate(user);
        if (token != null) {
            return ResponseEntity.ok().body("Token has been generated " + token);
        }
        return ResponseEntity.badRequest().body("Invalid username or password");
    }
}

package com.meghana.campusrecruitment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.dto.LoginRequest;
import com.meghana.campusrecruitment.dto.RegisterRequest;
import com.meghana.campusrecruitment.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")

@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginRequest request) {

    return ResponseEntity.ok(authService.login(request));
}
}
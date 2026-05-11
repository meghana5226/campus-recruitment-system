package com.meghana.campusrecruitment.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.dto.LoginRequest;
import com.meghana.campusrecruitment.dto.RegisterRequest;
import com.meghana.campusrecruitment.entity.User;
import com.meghana.campusrecruitment.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return "User Registered Successfully!";
    }

   public String login(LoginRequest request) {

    System.out.println("EMAIL = " + request.getEmail());

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

    System.out.println("DB USER = " + user);

    System.out.println("DB PASSWORD = " + user.getPassword());

    boolean matched =
            passwordEncoder.matches(request.getPassword(), user.getPassword());

    System.out.println("MATCHED = " + matched);

    return jwtService.generateToken(user.getEmail());
}
}
package com.meghana.campusrecruitment.dto;

import com.meghana.campusrecruitment.enums.Role;

import lombok.Data;

@Data
public class RegisterRequest {

    private String fullName;

    private String email;

    private String password;

    private Role role;
}
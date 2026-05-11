package com.meghana.campusrecruitment.student.dto;

import lombok.Data;

@Data
public class StudentProfileRequest {

    private String fullName;

    private String email;

    private String phone;

    private String collegeName;

    private String branch;

    private Double cgpa;

    private String skills;

    private String resumeUrl;

    private String linkedinUrl;

    private String githubUrl;
}
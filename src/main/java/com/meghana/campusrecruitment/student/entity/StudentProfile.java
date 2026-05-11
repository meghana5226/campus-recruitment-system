package com.meghana.campusrecruitment.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_profiles")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
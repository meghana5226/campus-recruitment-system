package com.meghana.campusrecruitment.student.service;

import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.student.dto.StudentProfileRequest;
import com.meghana.campusrecruitment.student.entity.StudentProfile;
import com.meghana.campusrecruitment.student.repository.StudentProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public String createProfile(StudentProfileRequest request) {

        StudentProfile profile = StudentProfile.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .collegeName(request.getCollegeName())
                .branch(request.getBranch())
                .cgpa(request.getCgpa())
                .skills(request.getSkills())
                .resumeUrl(request.getResumeUrl())
                .linkedinUrl(request.getLinkedinUrl())
                .githubUrl(request.getGithubUrl())
                .build();

        studentProfileRepository.save(profile);

        return "Student Profile Created Successfully!";
    }
    public StudentProfile getProfile(Long id) {

    return studentProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profile not found"));
}
public String updateProfile(
        Long id,
        StudentProfileRequest request) {

    StudentProfile profile = studentProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profile not found"));

    profile.setFullName(request.getFullName());
    profile.setEmail(request.getEmail());
    profile.setPhone(request.getPhone());
    profile.setCollegeName(request.getCollegeName());
    profile.setBranch(request.getBranch());
    profile.setCgpa(request.getCgpa());
    profile.setSkills(request.getSkills());
    profile.setResumeUrl(request.getResumeUrl());
    profile.setLinkedinUrl(request.getLinkedinUrl());
    profile.setGithubUrl(request.getGithubUrl());

    studentProfileRepository.save(profile);

    return "Student Profile Updated Successfully!";
}
public String deleteProfile(Long id) {

    StudentProfile profile = studentProfileRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Profile not found"));

    studentProfileRepository.delete(profile);

    return "Student Profile Deleted Successfully!";
}
}
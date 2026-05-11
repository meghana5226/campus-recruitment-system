package com.meghana.campusrecruitment.student.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.student.dto.StudentProfileRequest;
import com.meghana.campusrecruitment.student.entity.StudentProfile;
import com.meghana.campusrecruitment.student.service.StudentProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor

public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @PostMapping("/create-profile")
    public String createProfile(
            @RequestBody StudentProfileRequest request) {

        return studentProfileService.createProfile(request);
    }
    @PutMapping("/{id}")
public String updateProfile(
        @PathVariable Long id,
        @RequestBody StudentProfileRequest request) {

    return studentProfileService.updateProfile(id, request);
}
@DeleteMapping("/{id}")
public String deleteProfile(
        @PathVariable Long id) {

    return studentProfileService.deleteProfile(id);
}

    @GetMapping("/{id}")
    public StudentProfile getProfile(
            @PathVariable Long id) {

        return studentProfileService.getProfile(id);
    }
}
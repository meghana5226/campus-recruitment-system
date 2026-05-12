package com.meghana.campusrecruitment.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.application.dto.ApplicationRequest;
import com.meghana.campusrecruitment.application.entity.Application;
import com.meghana.campusrecruitment.application.enums.ApplicationStatus;
import com.meghana.campusrecruitment.application.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor

public class ApplicationController {

    private final ApplicationService applicationService;

    // APPLY TO JOB
    @PostMapping
    public String applyToJob(
            @RequestBody ApplicationRequest request) {

        return applicationService.applyToJob(request);
    }

    // GET APPLICATIONS BY STUDENT
    @GetMapping("/student/{studentId}")
    public List<Application> getApplicationsByStudent(
            @PathVariable Long studentId) {

        return applicationService
                .getApplicationsByStudent(studentId);
    }

    // GET APPLICATIONS BY JOB
    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJob(
            @PathVariable Long jobId) {

        return applicationService
                .getApplicationsByJob(jobId);
    }

    // UPDATE APPLICATION STATUS
    @PutMapping("/{applicationId}/status")
    public String updateStatus(
            @PathVariable Long applicationId,
            @RequestParam ApplicationStatus status) {

        return applicationService
                .updateStatus(applicationId, status);
    }
}
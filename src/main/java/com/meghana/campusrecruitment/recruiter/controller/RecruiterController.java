package com.meghana.campusrecruitment.recruiter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.recruiter.dto.RecruiterRequest;
import com.meghana.campusrecruitment.recruiter.entity.Recruiter;
import com.meghana.campusrecruitment.recruiter.service.RecruiterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recruiters")
@RequiredArgsConstructor

public class RecruiterController {

    private final RecruiterService recruiterService;

    // CREATE RECRUITER
    @PostMapping
    public String createRecruiter(
            @RequestBody RecruiterRequest request) {

        return recruiterService.createRecruiter(request);
    }

    // GET SINGLE RECRUITER
    @GetMapping("/{id}")
    public Recruiter getRecruiter(
            @PathVariable Long id) {

        return recruiterService.getRecruiter(id);
    }

    // GET ALL RECRUITERS
    @GetMapping
    public List<Recruiter> getAllRecruiters() {

        return recruiterService.getAllRecruiters();
    }

    // DELETE RECRUITER
    @DeleteMapping("/{id}")
    public String deleteRecruiter(
            @PathVariable Long id) {

        return recruiterService.deleteRecruiter(id);
    }
}
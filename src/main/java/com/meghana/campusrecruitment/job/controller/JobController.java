package com.meghana.campusrecruitment.job.controller;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.job.dto.JobRequest;
import com.meghana.campusrecruitment.job.dto.JobResponse;
import com.meghana.campusrecruitment.job.service.JobService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@Validated

public class JobController {

    private final JobService jobService;

    // CREATE JOB
    @PostMapping
    public String createJob(
            @Valid @RequestBody JobRequest request) {

        return jobService.createJob(request);
    }

    // GET SINGLE JOB
    @GetMapping("/{id}")
    public JobResponse getJobById(
            @PathVariable Long id) {

        return jobService.getJob(id);
    }

    // GET ALL JOBS
    @GetMapping
    public Page<JobResponse> getAllJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return jobService.getAllJobs(page, size);
    }

    // SEARCH JOBS
    @GetMapping("/search")
    public Page<JobResponse> searchJobs(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return jobService.searchJobs(
                keyword,
                page,
                size
        );
    }

    // UPDATE JOB
    @PutMapping("/{id}")
    public String updateJob(
            @PathVariable Long id,
            @Valid @RequestBody JobRequest request) {

        return jobService.updateJob(id, request);
    }

    // DELETE JOB
    @DeleteMapping("/{id}")
    public String deleteJob(
            @PathVariable Long id) {

        return jobService.deleteJob(id);
    }
}
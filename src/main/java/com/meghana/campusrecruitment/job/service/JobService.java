package com.meghana.campusrecruitment.job.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.job.dto.JobRequest;
import com.meghana.campusrecruitment.job.entity.Job;
import com.meghana.campusrecruitment.job.repository.JobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class JobService {

    private final JobRepository jobRepository;

    // CREATE JOB
    public String createJob(JobRequest request) {

        Job job = Job.builder()
                .title(request.getTitle())
                .companyName(request.getCompanyName())
                .description(request.getDescription())
                .location(request.getLocation())
                .salaryPackage(request.getSalaryPackage())
                .skillsRequired(request.getSkillsRequired())
                .jobType(request.getJobType())
                .applicationDeadline(request.getApplicationDeadline())
                .build();

        jobRepository.save(job);

        return "Job Created Successfully!";
    }

    // GET SINGLE JOB
    public Job getJob(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // GET ALL JOBS WITH PAGINATION
    public Page<Job> getAllJobs(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return jobRepository.findAll(pageable);
    }

    // SEARCH JOBS
    public Page<Job> searchJobs(
            String keyword,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return jobRepository
                .findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(
                        keyword,
                        keyword,
                        pageable
                );
    }

    // UPDATE JOB
    public String updateJob(Long id, JobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setTitle(request.getTitle());
        job.setCompanyName(request.getCompanyName());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalaryPackage(request.getSalaryPackage());
        job.setSkillsRequired(request.getSkillsRequired());
        job.setJobType(request.getJobType());
        job.setApplicationDeadline(request.getApplicationDeadline());

        jobRepository.save(job);

        return "Job Updated Successfully!";
    }

    // DELETE JOB
    public String deleteJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        jobRepository.delete(job);

        return "Job Deleted Successfully!";
    }
}
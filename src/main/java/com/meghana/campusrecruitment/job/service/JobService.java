package com.meghana.campusrecruitment.job.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.job.dto.JobRequest;
import com.meghana.campusrecruitment.job.dto.JobResponse;
import com.meghana.campusrecruitment.job.entity.Job;
import com.meghana.campusrecruitment.job.repository.JobRepository;
import com.meghana.campusrecruitment.recruiter.entity.Recruiter;
import com.meghana.campusrecruitment.recruiter.repository.RecruiterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class JobService {

    private final JobRepository jobRepository;

    private final RecruiterRepository recruiterRepository;

    // CREATE JOB
    public String createJob(JobRequest request) {

        Recruiter recruiter = recruiterRepository
                .findById(request.getRecruiterId())
                .orElseThrow(() ->
                        new RuntimeException("Recruiter not found"));

        Job job = Job.builder()
                .title(request.getTitle())
                .companyName(request.getCompanyName())
                .description(request.getDescription())
                .location(request.getLocation())
                .salaryPackage(request.getSalaryPackage())
                .skillsRequired(request.getSkillsRequired())
                .jobType(request.getJobType())
                .applicationDeadline(request.getApplicationDeadline())
                .recruiter(recruiter)
                .build();

        jobRepository.save(job);

        return "Job Created Successfully!";
    }

    // GET SINGLE JOB
    public JobResponse getJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        return mapToResponse(job);
    }

    // GET ALL JOBS
    public Page<JobResponse> getAllJobs(
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return jobRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    // SEARCH JOBS
    public Page<JobResponse> searchJobs(
            String keyword,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return jobRepository
                .findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(
                        keyword,
                        keyword,
                        pageable
                )
                .map(this::mapToResponse);
    }

    // UPDATE JOB
    public String updateJob(
            Long id,
            JobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

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
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        jobRepository.delete(job);

        return "Job Deleted Successfully!";
    }

    // DTO MAPPING
    private JobResponse mapToResponse(Job job) {

        return JobResponse.builder()
                .id(job.getId())
                .title(job.getTitle())
                .companyName(job.getCompanyName())
                .description(job.getDescription())
                .location(job.getLocation())
                .salaryPackage(job.getSalaryPackage())
                .skillsRequired(job.getSkillsRequired())
                .jobType(job.getJobType())
                .applicationDeadline(job.getApplicationDeadline())
                .createdAt(job.getCreatedAt())

                .recruiterName(
                        job.getRecruiter() != null
                                ? job.getRecruiter().getRecruiterName()
                                : null
                )

                .recruiterCompany(
                        job.getRecruiter() != null
                                ? job.getRecruiter().getCompanyName()
                                : null
                )

                .build();
    }
}
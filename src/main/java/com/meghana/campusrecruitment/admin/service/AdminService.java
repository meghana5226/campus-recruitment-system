package com.meghana.campusrecruitment.admin.service;

import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.admin.dto.AdminDashboardResponse;
import com.meghana.campusrecruitment.application.repository.ApplicationRepository;
import com.meghana.campusrecruitment.job.repository.JobRepository;
import com.meghana.campusrecruitment.recruiter.repository.RecruiterRepository;
import com.meghana.campusrecruitment.student.repository.StudentProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AdminService {

    private final StudentProfileRepository studentRepository;

    private final RecruiterRepository recruiterRepository;

    private final JobRepository jobRepository;

    private final ApplicationRepository applicationRepository;

    // DASHBOARD STATS
    public AdminDashboardResponse getDashboardStats() {

        return AdminDashboardResponse.builder()
                .totalStudents(studentRepository.count())
                .totalRecruiters(recruiterRepository.count())
                .totalJobs(jobRepository.count())
                .totalApplications(applicationRepository.count())
                .build();
    }
}
package com.meghana.campusrecruitment.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.application.dto.ApplicationRequest;
import com.meghana.campusrecruitment.application.entity.Application;
import com.meghana.campusrecruitment.application.enums.ApplicationStatus;
import com.meghana.campusrecruitment.application.repository.ApplicationRepository;
import com.meghana.campusrecruitment.job.entity.Job;
import com.meghana.campusrecruitment.job.repository.JobRepository;
import com.meghana.campusrecruitment.student.entity.StudentProfile;
import com.meghana.campusrecruitment.student.repository.StudentProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final StudentProfileRepository studentProfileRepository;

    private final JobRepository jobRepository;

    // APPLY TO JOB
    public String applyToJob(ApplicationRequest request) {

        StudentProfile student = studentProfileRepository
                .findById(request.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Job job = jobRepository
                .findById(request.getJobId())
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        Application application = Application.builder()
                .student(student)
                .job(job)
                .resumeUrl(request.getResumeUrl())
                .status(ApplicationStatus.APPLIED)
                .build();

        applicationRepository.save(application);

        return "Applied Successfully!";
    }

    // GET APPLICATIONS BY STUDENT
    public List<Application> getApplicationsByStudent(Long studentId) {

        return applicationRepository.findByStudentId(studentId);
    }

    // GET APPLICATIONS BY JOB
    public List<Application> getApplicationsByJob(Long jobId) {

        return applicationRepository.findByJobId(jobId);
    }

    // UPDATE APPLICATION STATUS
    public String updateStatus(
            Long applicationId,
            ApplicationStatus status) {

        Application application = applicationRepository
                .findById(applicationId)
                .orElseThrow(() ->
                        new RuntimeException("Application not found"));

        application.setStatus(status);

        applicationRepository.save(application);

        return "Application Status Updated!";
    }
}
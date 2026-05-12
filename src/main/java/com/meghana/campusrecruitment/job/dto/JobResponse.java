package com.meghana.campusrecruitment.job.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.meghana.campusrecruitment.job.enums.JobType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class JobResponse {

    private Long id;

    private String title;

    private String companyName;

    private String description;

    private String location;

    private Double salaryPackage;

    private String skillsRequired;

    private JobType jobType;

    private LocalDate applicationDeadline;

    private LocalDateTime createdAt;

    private String recruiterName;

    private String recruiterCompany;
}
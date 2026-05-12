package com.meghana.campusrecruitment.job.dto;

import java.time.LocalDate;

import com.meghana.campusrecruitment.job.enums.JobType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String companyName;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    @NotNull
    private Double salaryPackage;

    @NotBlank
    private String skillsRequired;

    @NotNull
    private JobType jobType;

    @NotNull
    private LocalDate applicationDeadline;
}
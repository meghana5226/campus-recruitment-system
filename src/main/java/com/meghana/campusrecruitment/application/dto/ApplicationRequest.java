package com.meghana.campusrecruitment.application.dto;

import lombok.Data;

@Data
public class ApplicationRequest {

    private Long studentId;

    private Long jobId;

    private String resumeUrl;
}
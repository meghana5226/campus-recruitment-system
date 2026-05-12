package com.meghana.campusrecruitment.admin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AdminDashboardResponse {

    private Long totalStudents;

    private Long totalRecruiters;

    private Long totalJobs;

    private Long totalApplications;
}
package com.meghana.campusrecruitment.recruiter.dto;

import lombok.Data;

@Data
public class RecruiterRequest {

    private String recruiterName;

    private String email;

    private String companyName;

    private String companyWebsite;

    private String designation;

    private String phone;
}
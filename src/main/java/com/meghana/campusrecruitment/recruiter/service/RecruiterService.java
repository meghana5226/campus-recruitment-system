package com.meghana.campusrecruitment.recruiter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meghana.campusrecruitment.recruiter.dto.RecruiterRequest;
import com.meghana.campusrecruitment.recruiter.entity.Recruiter;
import com.meghana.campusrecruitment.recruiter.repository.RecruiterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    // CREATE RECRUITER
    public String createRecruiter(RecruiterRequest request) {

        Recruiter recruiter = Recruiter.builder()
                .recruiterName(request.getRecruiterName())
                .email(request.getEmail())
                .companyName(request.getCompanyName())
                .companyWebsite(request.getCompanyWebsite())
                .designation(request.getDesignation())
                .phone(request.getPhone())
                .build();

        recruiterRepository.save(recruiter);

        return "Recruiter Created Successfully!";
    }

    // GET SINGLE RECRUITER
    public Recruiter getRecruiter(Long id) {

        return recruiterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recruiter not found"));
    }

    // GET ALL RECRUITERS
    public List<Recruiter> getAllRecruiters() {

        return recruiterRepository.findAll();
    }

    // DELETE RECRUITER
    public String deleteRecruiter(Long id) {

        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Recruiter not found"));

        recruiterRepository.delete(recruiter);

        return "Recruiter Deleted Successfully!";
    }
}
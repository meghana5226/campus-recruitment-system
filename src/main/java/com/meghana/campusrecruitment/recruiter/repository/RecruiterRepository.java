package com.meghana.campusrecruitment.recruiter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meghana.campusrecruitment.recruiter.entity.Recruiter;

public interface RecruiterRepository
        extends JpaRepository<Recruiter, Long> {

    Optional<Recruiter> findByEmail(String email);
}
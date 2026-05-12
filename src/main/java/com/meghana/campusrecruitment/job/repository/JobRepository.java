package com.meghana.campusrecruitment.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.meghana.campusrecruitment.job.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    Page<Job> findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(
            String title,
            String companyName,
            Pageable pageable
    );
}
package com.meghana.campusrecruitment.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meghana.campusrecruitment.application.entity.Application;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByJobId(Long jobId);
}
package com.meghana.campusrecruitment.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meghana.campusrecruitment.student.entity.StudentProfile;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfile, Long> {

}
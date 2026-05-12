package com.meghana.campusrecruitment.application.entity;

import java.time.LocalDateTime;

import com.meghana.campusrecruitment.application.enums.ApplicationStatus;
import com.meghana.campusrecruitment.job.entity.Job;
import com.meghana.campusrecruitment.student.entity.StudentProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY APPLICATIONS → ONE STUDENT
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile student;

    // MANY APPLICATIONS → ONE JOB
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private String resumeUrl;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private LocalDateTime appliedAt;

    @PrePersist
    public void prePersist() {
        appliedAt = LocalDateTime.now();

        if (status == null) {
            status = ApplicationStatus.APPLIED;
        }
    }
}
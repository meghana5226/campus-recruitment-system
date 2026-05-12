package com.meghana.campusrecruitment.recruiter.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.meghana.campusrecruitment.job.entity.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recruiters")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recruiterName;

    @Column(unique = true)
    private String email;

    private String companyName;

    private String companyWebsite;

    private String designation;

    private String phone;

    private LocalDateTime createdAt;

    // ONE RECRUITER → MANY JOBS
    @JsonManagedReference
@OneToMany(mappedBy = "recruiter")

    private List<Job> jobs;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
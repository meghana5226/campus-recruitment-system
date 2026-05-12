package com.meghana.campusrecruitment.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meghana.campusrecruitment.admin.dto.AdminDashboardResponse;
import com.meghana.campusrecruitment.admin.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor

public class AdminController {

    private final AdminService adminService;

    // DASHBOARD API
    @GetMapping("/dashboard")
    public AdminDashboardResponse getDashboard() {

        return adminService.getDashboardStats();
    }
}
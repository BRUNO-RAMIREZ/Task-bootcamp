package com.bootcamp.reverse_proxy.controller;

import com.bootcamp.reverse_proxy.api.response.EmployeeReportResponse;
import com.bootcamp.reverse_proxy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Bruno Ramirez
 */
@RequiredArgsConstructor
@RequestMapping("/api/reports")
public class EmployeeReportController {

    private final EmployeeService employeeService;

    @GetMapping("/summary")
    public ResponseEntity<EmployeeReportResponse> getMyReport() {
        return ResponseEntity.ok(employeeService.getReportForLoggedEmployee());
    }
}
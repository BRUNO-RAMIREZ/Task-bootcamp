package com.bootcamp.reverse_proxy.controller;


import com.bootcamp.reverse_proxy.model.Employee;
import com.bootcamp.reverse_proxy.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bruno Ramirez
 */
@RestController
@RequestMapping("/api/profile")
public class EmployeeProfileController {

    private final EmployeeService employeeService;

    public EmployeeProfileController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Employee> getMyProfile() {
        return ResponseEntity.ok(employeeService.getLoggedEmployee());
    }
}
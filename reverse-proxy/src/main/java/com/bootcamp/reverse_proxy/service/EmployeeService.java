package com.bootcamp.reverse_proxy.service;

import com.bootcamp.reverse_proxy.api.response.EmployeeReportResponse;
import com.bootcamp.reverse_proxy.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author Bruno Ramirez
 */
@Service
public class EmployeeService {

    public Employee getLoggedEmployee() {
        return new Employee(1L, "Andres Ramos", "Developer", LocalDate.of(2018, 3, 1));
    }

    public EmployeeReportResponse getReportForLoggedEmployee() {
        Employee employee = getLoggedEmployee();

        return new EmployeeReportResponse(
                employee.getName(),
                employee.getPosition(),
                employee.getJoinDate(),
                "Marzo 2025",
                3200.00
        );
    }
}


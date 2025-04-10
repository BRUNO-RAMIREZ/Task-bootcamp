package com.bootcamp.reverse_proxy.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Bruno Ramirez
 */
@AllArgsConstructor
@Setter
@Getter
public class EmployeeReportResponse {

    private String name;

    private String position;

    private LocalDate joinDate;

    private String period;

    private Double salary;
}

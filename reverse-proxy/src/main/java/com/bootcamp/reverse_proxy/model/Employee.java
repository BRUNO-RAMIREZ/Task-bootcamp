package com.bootcamp.reverse_proxy.model;

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
public class Employee {

    private Long id;

    private String name;

    private String position;

    private LocalDate joinDate;
}
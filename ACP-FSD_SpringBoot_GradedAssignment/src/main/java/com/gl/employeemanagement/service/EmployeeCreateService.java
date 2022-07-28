package com.gl.employeemanagement.service;

import java.util.List;

import com.gl.employeemanagement.model.Employee;

public interface EmployeeCreateService {

	String saveAllEmployees(List<Employee> employees);

}
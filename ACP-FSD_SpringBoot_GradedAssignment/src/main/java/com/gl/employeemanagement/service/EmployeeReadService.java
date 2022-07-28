package com.gl.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.gl.employeemanagement.model.Employee;

public interface EmployeeReadService {

	List<Employee> listAllEmployees();

	Optional<Employee> fetchEmployeeById(Integer id);

	List<Employee> getEmployeesSortedByfirstName(Direction direction);

	List<Employee> fetchEmployeesByFirstName(String firstName);

}
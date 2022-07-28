package com.gl.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.service.EmployeeReadService;

@RestController
@RequestMapping("/readService")
public class EmployeeReadController {

	@Autowired
	EmployeeReadService readService;

	@GetMapping("/listAll")
	public List<Employee> listAll() {
		return readService.listAllEmployees();
	}

	@GetMapping("/findById")
	public Optional<Employee> findById(Integer id) {
		return readService.fetchEmployeeById(id);
	}

	@GetMapping("/getEmployeesSortedByFirstName")
	public List<Employee> getSortedByFirstName(Direction direction) {
		return readService.getEmployeesSortedByfirstName(direction);
	}

	@GetMapping("/fetchEmployeesByFirstName")
	public List<Employee> fetchEmployeesByFirstName(String firstName) {
		return readService.fetchEmployeesByFirstName(firstName);
	}

}

package com.gl.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.service.EmployeeCreateService;

@RestController
@RequestMapping("/createService")
public class EmployeeCreateController {

	@Autowired
	EmployeeCreateService createService;

	@PostMapping("/addNewEmployees")
	public String addNewEmployees(@RequestBody List<Employee> employees) {
		return createService.saveAllEmployees(employees);

	}

}

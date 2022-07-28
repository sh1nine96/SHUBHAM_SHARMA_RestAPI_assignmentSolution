package com.gl.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.service.EmployeeUpdateService;

@RestController
@RequestMapping("/updateService")
public class EmployeeUpdateController {

	@Autowired
	EmployeeUpdateService updateService;

	@PutMapping("/updateExistingEmployeeRecord")
	public String updateExistingEmployeeRecord(@RequestBody Employee employee) {
		return updateService.updateExistingEmployee(employee);
	}
}

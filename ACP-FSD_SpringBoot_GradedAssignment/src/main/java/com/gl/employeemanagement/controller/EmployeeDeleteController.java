package com.gl.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.service.EmployeeDeleteService;

@RestController
@RequestMapping("/deleteService")
public class EmployeeDeleteController {

	@Autowired
	EmployeeDeleteService deleteService;

	@DeleteMapping("/deleteEmployeebyId")
	public String deleteEmployeebyId(@RequestParam("id") Integer id) {
		return deleteService.deleteEmployeeById(id);
	}

}

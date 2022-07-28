package com.gl.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gl.employeemanagement.model.Role;
import com.gl.employeemanagement.service.RolesAndUsersService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RolesAndUsersService roleService;

	@PostMapping("/addNewRole")
	public Role addNewRole(@RequestParam String name) {
		return roleService.addNewRole(name);
	}

}

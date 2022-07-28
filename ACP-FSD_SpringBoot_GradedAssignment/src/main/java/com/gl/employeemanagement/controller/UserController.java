package com.gl.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagement.model.User;
import com.gl.employeemanagement.service.RolesAndUsersService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	RolesAndUsersService rolesAndUsersService;

	@PostMapping("/addNewUser")
	public User addNewUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("role_name") String role_name) {
		return rolesAndUsersService.addNewUser(username, password, role_name);
	}

}

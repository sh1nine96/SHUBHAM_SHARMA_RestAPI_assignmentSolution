package com.gl.employeemanagement.service;

import com.gl.employeemanagement.model.Role;
import com.gl.employeemanagement.model.User;

public interface RolesAndUsersService {

	Role addNewRole(String name);

	User addNewUser(String username, String password, String role_name);

}
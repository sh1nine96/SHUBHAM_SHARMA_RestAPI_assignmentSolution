package com.gl.employeemanagement.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.model.Role;
import com.gl.employeemanagement.model.User;
import com.gl.employeemanagement.repository.RoleRepository;
import com.gl.employeemanagement.repository.UserRepository;
import com.gl.employeemanagement.service.RolesAndUsersService;

@Service
public class RolesAndUsersServiceImpl implements RolesAndUsersService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addNewRole(String name) {
		Role role = roleRepository.findRoleByName(name);
		if (role != null)
			return role;
		role = new Role();
		role.setName(name);

		return roleRepository.save(role);
	}

	@Override
	public User addNewUser(String username, String password, String role_name) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));

		List<Role> roles = new ArrayList<>();
		Role role = roleRepository.findRoleByName(role_name);
		if (role == null)
			role = addNewRole(role_name);
		roles.add(role);
		user.setRoles(roles);

		return userRepository.save(user);

	}

}

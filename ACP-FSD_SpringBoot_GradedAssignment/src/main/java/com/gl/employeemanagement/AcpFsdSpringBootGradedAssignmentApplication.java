package com.gl.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.employeemanagement.model.Role;
import com.gl.employeemanagement.model.User;
import com.gl.employeemanagement.repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class AcpFsdSpringBootGradedAssignmentApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcpFsdSpringBootGradedAssignmentApplication.class, args);
		System.out.println("Server started");
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setId(1);
		user.setUsername("shubham");
		user.setPassword(new BCryptPasswordEncoder().encode("shubham"));

		List<Role> roles = new ArrayList<>();
		roles.add(new Role(1, "ADMIN"));
		user.setRoles(roles);

		userRepository.save(user);

	}

}

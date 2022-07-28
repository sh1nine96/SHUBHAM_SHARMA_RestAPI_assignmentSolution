package com.gl.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.model.User;
import com.gl.employeemanagement.repository.UserRepository;
import com.gl.employeemanagement.security.MyCustomUserDetails;

@Service
public class EmployeeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userEntity = userRepository.getUserByUsername(username);

		if (userEntity == null) {
			// throw exception
			throw new UsernameNotFoundException("Couldn't find the user");
		}
		return new MyCustomUserDetails(userEntity);
	}

}

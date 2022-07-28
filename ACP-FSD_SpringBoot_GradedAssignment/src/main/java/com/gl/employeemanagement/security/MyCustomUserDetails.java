package com.gl.employeemanagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.gl.employeemanagement.model.Role;
import com.gl.employeemanagement.model.User;

public class MyCustomUserDetails implements UserDetails {

	private User userEntity;

	public MyCustomUserDetails(User userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = userEntity.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {

		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {

		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}

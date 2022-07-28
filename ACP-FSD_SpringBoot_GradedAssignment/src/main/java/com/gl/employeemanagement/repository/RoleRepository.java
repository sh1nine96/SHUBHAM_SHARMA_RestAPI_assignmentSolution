package com.gl.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeemanagement.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findRoleByName(String name);
}

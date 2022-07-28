package com.gl.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.repository.EmployeeRepository;
import com.gl.employeemanagement.service.EmployeeDeleteService;

@Service
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
		return "Employee with id: " + id + " is deleted";
	}

}

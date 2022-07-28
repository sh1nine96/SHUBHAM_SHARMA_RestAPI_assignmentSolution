package com.gl.employeemanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.repository.EmployeeRepository;
import com.gl.employeemanagement.service.EmployeeUpdateService;

@Service
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String updateExistingEmployee(Employee employee) {
		boolean exists = employeeRepository.existsById(employee.getId());
		if (exists) {
			employeeRepository.saveAndFlush(employee);
			return "Employee record updated";
		} else
			throw new RuntimeException("The id: " + employee.getId() + " you're trying to update is not present");
	}

}

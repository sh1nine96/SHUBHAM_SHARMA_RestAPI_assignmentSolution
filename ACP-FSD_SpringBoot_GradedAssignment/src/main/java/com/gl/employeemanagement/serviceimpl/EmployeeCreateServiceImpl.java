package com.gl.employeemanagement.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.repository.EmployeeRepository;
import com.gl.employeemanagement.service.EmployeeCreateService;

@Service
public class EmployeeCreateServiceImpl implements EmployeeCreateService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String saveAllEmployees(List<Employee> employees) {
		employeeRepository.saveAll(employees);
		return "saved to DB";
	}

}

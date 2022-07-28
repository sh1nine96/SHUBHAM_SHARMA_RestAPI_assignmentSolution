package com.gl.employeemanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeemanagement.model.Employee;
import com.gl.employeemanagement.repository.EmployeeRepository;
import com.gl.employeemanagement.service.EmployeeReadService;

@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> fetchEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getEmployeesSortedByfirstName(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public List<Employee> fetchEmployeesByFirstName(String firstName) {
		Employee employeeByFirstName = new Employee();
		employeeByFirstName.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(employeeByFirstName, exampleMatcher);
		return employeeRepository.findAll(example);
	}

}

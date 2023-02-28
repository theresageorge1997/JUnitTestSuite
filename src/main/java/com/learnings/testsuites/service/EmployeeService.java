package com.learnings.testsuites.service;

import com.learnings.testsuites.model.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> getEmployees();

	Employee getEmployee(Long employeeId);

	Employee createEmployee(Employee employee);

	void deleteByEmployeeId(Long employeeId);

	void UpdateEmployee(Long employeeId, Employee employee);

}

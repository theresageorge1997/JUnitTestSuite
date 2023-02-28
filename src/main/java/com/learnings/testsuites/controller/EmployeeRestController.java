package com.learnings.testsuites.controller;

import com.learnings.testsuites.model.Employee;
import com.learnings.testsuites.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

	@GetMapping("/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") Long employeeId, HttpServletRequest request) {
		LOGGER.info("REST API(GET) to retrieve single employee..............");
		return employeeService.getEmployee(employeeId);
	}

	@GetMapping
	public List<Employee> getEmployees(HttpServletRequest request) {
		LOGGER.info("REST API(GET) to retrieve all employees..............");
		return employeeService.getEmployees();
	}

	@PostMapping
	public String createEmployee(@RequestBody Employee employee, HttpServletRequest request) {
		LOGGER.info("REST API(POST) to create a employee..............");
		employeeService.createEmployee(employee);
		return "Inserted Successfully";
	}

	@PutMapping("/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee employee,
			HttpServletRequest request) {
		LOGGER.info("REST API(PUT) to update a employee..............");
		employeeService.UpdateEmployee(employeeId, employee);
		return "Updated Successfully";
	}

	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long employeeId, HttpServletRequest request) {
		LOGGER.info("REST API(DELETE) to delete a employee..............");
		employeeService.deleteByEmployeeId(employeeId);
		return "Deleted Successfully";
	}

}

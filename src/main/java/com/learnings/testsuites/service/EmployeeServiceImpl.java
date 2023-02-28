package com.learnings.testsuites.service;
import com.learnings.testsuites.model.Employee;
import com.learnings.testsuites.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<Employee> getEmployees() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			LOGGER.error("Unable to establish DB Connection ....", e);
			return null;
		}
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		try {
			Employee existingModel = employeeRepository.findById(employeeId).orElse(null);
			if (existingModel == null) {
				LOGGER.warn("No Employee record existing with given ID...{}", employeeId);
				LOGGER.info("Execution terminated because of no data found :: employeeID - {}", employeeId);
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee record not found !!!");
			}
			return employeeRepository.findById(employeeId).orElse(null);
		} catch (Exception e) {
			LOGGER.error("Unable to establish DB Connection ....", e);
			return null;
		}
	}

	@Override
	public Employee createEmployee(Employee employee) {
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			LOGGER.error("Unable to establish DB Connection ....", e);
			return null;
		}
	}

	@Override
	public void deleteByEmployeeId(Long employeeId) {
		try {
			Employee existingModel = employeeRepository.findById(employeeId).orElse(null);

			if (existingModel == null) {
				LOGGER.warn("No Employee record existing with given ID...{}", employeeId);
				LOGGER.info("Execution terminated because of no data found :: employeeID - {}", employeeId);
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee record not found !!!");
			}
			employeeRepository.deleteById(employeeId);
		} catch (Exception e) {

			LOGGER.error("Unable to establish DB Connection ....", e);

		}

	}

	@Override
	public void UpdateEmployee(Long employeeId, Employee employee) {
		try {
			Employee existingModel = employeeRepository.findById(employeeId).orElse(null);

			if (existingModel == null) {
				LOGGER.warn("No Employee record existing with given ID...{}", employee.getId());
				LOGGER.info("Execution terminated because of no data found :: employeeID - {}", employee.getId());
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee record not found !!!");
			}

			employee.setId(existingModel.getId());
			employeeRepository.save(employee);
		} catch (Exception e) {

			LOGGER.error("Unable to establish DB Connection ....", e);

		}
	}

}
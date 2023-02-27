package com.learnings.testsuites.repository;

import com.learnings.testsuites.model.Employee;
import com.learnings.testsuites.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){
        Employee employee = Employee.builder().firstName("Theresa").lastName("George").email("t@gmail.com").build();
        employeeRepository.save(employee);
        Assertions.assertThat(employee.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    public void getEmployeeTest(){
        Employee employee =  employeeRepository.findById(1L).get();
        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void  getListofEmployeeesTest(){
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void  updateEmployeeeTest(){
        Employee employee = employeeRepository.findById(1L).get();
        employee.setEmail("theresageorge1997@gmail.com");
        Employee employeeupdated = employeeRepository.save(employee);
        Assertions.assertThat(employee.getEmail()).isEqualTo("theresageorge1997@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void  deleteEmployeeeTest(){
        Employee employee = employeeRepository.findById(1L).get();
        employeeRepository.delete(employee);

        Employee employee1 = null;
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("t@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }
        Assertions.assertThat(employee1).isNull();
    }
}

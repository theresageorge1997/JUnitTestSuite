package com.learnings.testsuites.suites;
import com.learnings.testsuites.controller.EmployeeRestControllerTests;
import com.learnings.testsuites.repository.EmployeeRepositoryTests;
import org.junit.platform.suite.api.*;



@Suite
@SuiteDisplayName("A demo Test Suite")
@SelectClasses({EmployeeRepositoryTests.class, EmployeeRestControllerTests.class})
public class JUnit5TestSuiteExample {

}




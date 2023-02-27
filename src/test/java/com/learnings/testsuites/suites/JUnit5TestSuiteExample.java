package com.learnings.testsuites.suites;


import com.learnings.testsuites.repository.EmployeeRepositoryTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@Suite
@SuiteDisplayName("A demo Test Suite")
@SelectClasses(EmployeeRepositoryTests.class)
public class JUnit5TestSuiteExample {

}




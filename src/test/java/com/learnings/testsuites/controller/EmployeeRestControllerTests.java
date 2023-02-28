package com.learnings.testsuites.controller;
import com.learnings.testsuites.model.Employee;
import com.learnings.testsuites.service.EmployeeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;

import org.skyscreamer.jsonassert.JSONAssert;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeRestController.class)
@WithMockUser
public class EmployeeRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    Employee mockEmployee = new Employee(1L, "Theresa", "George","t@gmail.com");

    @Test
    public void retrieveDetailsForEmployee() throws Exception {

        Mockito.when(employeeService.getEmployee(Mockito.anyLong())).thenReturn(mockEmployee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/employeesemployees/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:1, firstName:\"Theresa\", lastName:\"George\", email:\"t@gmail.com\"}";

        String actual = "{id:123, name:\"John\", zip:\"33025\"}";
        JSONAssert.assertEquals(
                "{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
    }

}

package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

public class EmployeeControllerTests extends AbstractTest {
   @Autowired
   private EmployeeService employeeService;
   
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void createEmployee() throws Exception {
	   String uri = "/api/employees/create";
	   Employee employee = new Employee(777, "prem", 45000.00, "SDE-II", "1994/02/05", 4);
	   
	   String inputJson = super.mapToJson(employee);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	   .contentType(MediaType.APPLICATION_JSON_VALUE)
	   .content(inputJson)).andReturn();
	      
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult.getResponse().getContentAsString();
	    assertEquals(content, employee.toString());
   }
   
   @Test
   public void getAllTest() throws Exception {
	   String uri = "/api/employees/getAll";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String employees = mvcResult.getResponse().getContentAsString();
	   assertTrue(employees.length() > 0);
   }
   
   @Test
   public void deleteEmployee() throws Exception {
      String uri = "/api/employees/delete/2";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertTrue(content.length() > 0);
   }
   
   @Test
   public void getByIdTest() throws Exception {
      String uri = "/api/employees/getById/2";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }
   
   @Test
   public void updateTest() throws Exception {
	   String uri = "/api/employees/update";
	   Employee employee = new Employee(777, "prem", 45000.00, "SDE-II", "1994/02/05", 4);
	   
	   String inputJson = super.mapToJson(employee);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	   .contentType(MediaType.APPLICATION_JSON_VALUE)
	   .content(inputJson)).andReturn();
	      
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult.getResponse().getContentAsString();
	    assertEquals(content, employee.toString());
   }
   
   @Test
   public void updateBioTest() throws Exception {
	   String uri = "/api/employees/bio/777";
	   Employee employee = new Employee(777, "prem", 45000.00, "SDE-II", "1994/02/05", 4);
	   String inputJson = super.mapToJson(employee);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.patch(uri)
	   .contentType(MediaType.APPLICATION_JSON_VALUE)
	   .content(inputJson)).andReturn();
	      
	    int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    String content = mvcResult.getResponse().getContentAsString();
	    assertEquals(content, inputJson.toString());
   }
}

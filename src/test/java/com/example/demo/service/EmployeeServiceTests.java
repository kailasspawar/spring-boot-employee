package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployee() {
		Employee employee = new Employee(777, "Sk", 45000.00, "PM", "1996/05/15", 9);
		return employee;
	}
	
	@Test
	public void getAllTest() {
		when(employeeRepository.findAll()).thenReturn(Stream
				.of(new Employee(111, "prem", 50000.00, "SDA", "1994/07/02", 2), 
					new Employee(222, "Raj", 40000.00, "QA", "1993/04/02", 2)).collect(Collectors.toList()));
		
		assertEquals(2, employeeService.getAll().size());
	}

	@Test
	public void createTest() {
		Employee employee = getEmployee();
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		assertEquals(employee, employeeService.create(employee));
	}
	
	@Test
	public void getEmployeeByIdTest() {
		Employee employee = getEmployee();
		when(employeeRepository.findByEmpId(777)).thenReturn(employee);
		
		assertEquals(employee, employeeService.getEmployeeById(777));
	}
	
	@Test
	public void updateBioTest() {
		Employee toPass = new Employee(null, null, null, "FullStack", "1994/12/02", 7);
		Employee expected = new Employee(777, "Sk", 45000.00, "FullStack", "1994/12/02", 7);
		when(employeeRepository.findByEmpId(777)).thenReturn(expected);
		when(employeeRepository.save(expected)).thenReturn(expected);

		assertEquals(expected, employeeService.updateBio(777, toPass));
	}
	
	@Test
	public void deleteByIdTest() {
		when(employeeRepository.existsById(777)).thenReturn(true);
		
		assertEquals("Record deleted Successfully\n", employeeService.deleteById(777));
	}
}

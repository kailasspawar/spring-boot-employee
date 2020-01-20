package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public String create(@RequestBody Employee employee) {
		Employee e = employeeService.create(employee);
		return e.toString();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee employee) {
		Employee e = employeeService.update(employee);
		return e.toString();
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}
	
	@GetMapping("/getById/{empId}")
	public Employee getEmployeeById(@PathVariable(name = "empId") Integer empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@GetMapping("getSalaryGreater/{empSalary}")
	public List<Employee> getEmployeesForSalaryGreaterThan(@PathVariable(name = "empSalary") Double empSalary) {
		return employeeService.getEmployeesForSalaryGreaterThan(empSalary);
	}
	
	@PatchMapping("bio/{empId}")
	public Employee updateBio(@PathVariable(name = "empId") Integer empId, @RequestBody Employee employee) {
		return employeeService.updateBio(empId, employee);
	}
	
	@PatchMapping("update-multiple")
	public Employee updateMultipleAttributes(@RequestParam Integer empId, @RequestParam String empName, 
		@RequestParam Double empSalary, @RequestParam Integer empYearsOfExperience) {
		return employeeService.updateMultipleAttributes(empId, empName, empSalary, empYearsOfExperience);
	}
	
	@DeleteMapping("/delete/{empId}")
	public String delete(@PathVariable(name = "empId") Integer empId) {
		return employeeService.deleteById(empId);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return employeeService.deleteAll();
	}
}

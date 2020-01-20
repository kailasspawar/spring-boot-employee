package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//create employee object
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(Integer empId) {
		return employeeRepository.findByEmpId(empId);
	}
	
	public List<Employee> getEmployeesForSalaryGreaterThan(Double empSalary) {
		return employeeRepository.findByEmpSalaryGreaterThan(empSalary);
	}
	
	public Employee updateBio(Integer empId, Employee employee) {
		Employee existing = employeeRepository.findByEmpId(empId);
		existing.setEmpDesignation(employee.getEmpDesignation());
		existing.setEmpDOB(employee.getEmpDOB());
		existing.setEmpYearsOfExperience(employee.getEmpYearsOfExperience());
		return employeeRepository.save(existing);
	}
	
	public Employee updateMultipleAttributes(Integer empId, String empName, 
		Double empSalary, Integer empYearsOfExperience) {
			Employee existing = employeeRepository.findByEmpId(empId);
			existing.setEmpName(empName);
			existing.setEmpSalary(empSalary);
			existing.setEmpYearsOfExperience(empYearsOfExperience);
			return employeeRepository.save(existing);
	}
	
	public String deleteById(Integer empId) {
		if (employeeRepository.existsById(empId)) {
			employeeRepository.deleteById(empId);
			return "Record deleted Successfully\n";
		}
		return "Record Not Fould\n";
	}
	
	public String deleteAll() {
		employeeRepository.deleteAll();
		return "All Records deleted\n";
	}
 }

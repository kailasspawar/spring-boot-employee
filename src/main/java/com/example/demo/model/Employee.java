package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	@Id
	private Integer empId;
	private String empName;
	private Double empSalary;
	private String empDesignation;
    private String empDOB;
	private Integer empYearsOfExperience;
	
	//Constructor
	public Employee
	(
	 Integer empId, String empName, Double empSalary, String empDesignation,
	 String empDOB, Integer empYearsOfExperience) {
		this.empId                = empId;
		this.empName              = empName;
		this.empSalary            = empSalary;
		this.empDesignation       = empDesignation;
		this.empDOB               = empDOB;
		this.empYearsOfExperience = empYearsOfExperience;
	}

	//Getters and Setters
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	
	public String toString() {
		return "Emp Id: " +empId+ " Emp Name: " + empName + " EmpSalary: " + empSalary + 
				" Emp Design: " + empDesignation + " Emp YOE: " + empYearsOfExperience +
				" Emp DOB: " + empDOB; 
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public Integer getEmpYearsOfExperience() {
		return empYearsOfExperience;
	}

	public void setEmpYearsOfExperience(Integer empYearsOfExperience) {
		this.empYearsOfExperience = empYearsOfExperience;
	}
	
}

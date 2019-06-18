package com.scp.mvc.service;

import java.util.List;

import com.scp.mvc.beans.Employee;

public interface EmpService {
	public boolean addEmployee(Employee bean);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployees();
	public List<Employee> deleteEmployee(int empId);
	public Employee updateEmployee(Employee bean);
		
}

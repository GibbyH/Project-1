package com.hksoftworks.dao;

import java.util.List;

import com.hksoftworks.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	boolean getEmployeeByEmailAndPassword(String username, String password);
	boolean isManager(Employee emp);
	Employee createEmployee(Employee emp);
	Employee updateEmployee(Employee empToBeUpdated);
	long deleteEmployee(Employee... empToBeDeleted);
}

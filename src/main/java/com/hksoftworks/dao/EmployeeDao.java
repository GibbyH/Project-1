package com.hksoftworks.dao;

import java.util.List;

import com.hksoftworks.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee getEmployeeByEmailAndPassword(String username, String password);
	Employee createEmployee(Employee emp);
	Employee updateEmployee(Employee empToBeUpdated);
	long deleteEmployee(Employee... empToBeDeleted);
}

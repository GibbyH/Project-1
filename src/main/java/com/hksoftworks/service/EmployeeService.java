package com.hksoftworks.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hksoftworks.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees (HttpServletRequest request, HttpServletResponse response);
	Employee createEmployee (HttpServletRequest request, HttpServletResponse response);
	boolean updateEmployee (HttpServletRequest request, HttpServletResponse response);
	

}

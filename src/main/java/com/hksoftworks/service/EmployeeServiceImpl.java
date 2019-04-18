package com.hksoftworks.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hksoftworks.dao.EmployeeDao;
import com.hksoftworks.dao.EmployeeDaoImpl;
import com.hksoftworks.model.Employee;


public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDao dao = new EmployeeDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		return dao.getAllEmployees();
	}

	@Override
	public Employee createEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			// From the http request body, pares json into a Todo object
			Employee emp = mapper.readValue(request.getInputStream(), Employee.class);
			return dao.createEmployee(emp);
		} catch (IOException e) {
			return null;
		}	
	}

	

}

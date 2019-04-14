package com.hksoftworks.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hksoftworks.JDBC.tables.EmployeeManager;
import com.hksoftworks.beans.Employee;
import com.hksoftworks.util.InputHelper;

public class ConnectDB {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("App started!");
		
		ConnectionManager.getInstance();
		
		EmployeeManager.displayAllRows();
		
		int empId = InputHelper.getIntergerInput("Select a row to update: ");
		
		Employee emp = EmployeeManager.getRow(empId);
		if(emp ==null) {
			System.err.println("Row not found.");
			return;
		}
		
		String lastName = InputHelper.getInput("Enter new last name: ");
		emp.setLastName(lastName);
		
		String firstName = InputHelper.getInput("Enter new first name: ");
		emp.setFirstName(firstName);
		
		String email = InputHelper.getInput("Enter new email: ");
		emp.setEmail(email);
		
		String pass = InputHelper.getInput("Enter new password: ");
		emp.setPass(pass);
		
		int managerId = InputHelper.getIntergerInput("Enter new manager ID: ");
		emp.setManagerId(managerId);
		
		if(EmployeeManager.update(emp))
			System.out.println("Excelsior!");
		else
			System.err.println("Hulk sad.");
		
		ConnectionManager.getInstance().close();
	}
}


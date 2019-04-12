package com.hksoftworks.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hksoftworks.JDBC.tables.Employees;
import com.hksoftworks.util.InputHelper;

public class ConnectDB {
	
	private static final String SQL = "SELECT * FROM employees WHERE last_name = ?";

	public static void main(String[] args) throws SQLException {
		
		ResultSet rs = null;
		
		String lastName;
		try {
			lastName = InputHelper.getInput("Enter last name: ");
		} catch (NullPointerException e) {
			System.err.println("Error: That person has left the building.");
			return;
		}
		
		try (
				Connection conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				){
			stmt.setString(1, lastName);
			rs = stmt.executeQuery();
			Employees.displayData(rs);
		} catch (SQLException e) {
			DBUtil.processException(e);
		} 
	}
}


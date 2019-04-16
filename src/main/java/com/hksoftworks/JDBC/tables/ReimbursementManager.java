package com.hksoftworks.JDBC.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hksoftworks.JDBC.ConnectionManager;

public class ReimbursementManager {
	
	public static void displayAllRows() throws SQLException {
		
		String sql = "SELECT request_num, emp_Id, amount, submitted, status FROM reimbursements";
		
		try (
			Connection conn = ConnectionManager.getConnection();
			Statement stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				){
			System.out.println("Reimbursements table: ");
		
			while (rs.next()) {
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("Request number: " + rs.getInt("REQUEST_NUM") + ": ");
				buffer.append(rs.getInt("EMP_ID") + ", ");
				buffer.append(rs.getBigDecimal("AMOUNT") + ", ");
				buffer.append(rs.getDate("SUBMITTED") + ", ");
				buffer.append(rs.getString("STATUS"));
				
				System.out.println(buffer.toString());
			}
		}
	}
}

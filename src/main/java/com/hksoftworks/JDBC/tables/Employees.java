package com.hksoftworks.JDBC.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees {

	public static void displayData(ResultSet rs) throws SQLException {
		
		rs.last();
		int nRows = rs.getRow();
		if(nRows == 0)
			System.out.println("No records found.");
		else {
			System.out.println("Number of employee records: " + nRows);
			rs.beforeFirst();
			
			while (rs.next()) {
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("Employee " + rs.getInt("EMP_ID") + ": ");
				buffer.append(rs.getString("LAST_NAME") + ", ");
				buffer.append(rs.getString("FIRST_NAME") + ", ");
				buffer.append(rs.getString("EMAIL") + ", ");
				buffer.append(rs.getInt("MANAGER_ID"));
				
				System.out.println(buffer.toString());
			}
		}
	}
}

package com.hksoftworks.JDBC.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees {

	public static void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("Employee " + rs.getInt("EMP_ID") + ": ");
			buffer.append(rs.getString("LAST_NAME") + ", ");
			buffer.append(rs.getString("FIRST_NAME") + ", ");
//			buffer.append(rs.getString("Email") + ", ");
//			buffer.append(rs.getInt("MANAGER_ID"));
			
			System.out.println(buffer.toString());
		}
	}
}

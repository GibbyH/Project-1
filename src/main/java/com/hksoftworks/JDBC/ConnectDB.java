package com.hksoftworks.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hksoftworks.JDBC.tables.Employees;

public class ConnectDB {

	public static void main(String[] args) throws SQLException {

		try (
				Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT emp_id, last_name, first_name FROM employees");
				){

			Employees.displayData(rs);
		} catch (SQLException e) {
			DBUtil.processException(e);
		} 
	}
}


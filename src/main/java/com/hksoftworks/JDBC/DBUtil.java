package com.hksoftworks.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "SYS as SYSDBA";
	private static final String PASSWORD = "Revature123";
	private static final String CONN_STRING = "jdbc:oracle:thin:@localhost:1521:ORCL";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}
	
	public static void processException(SQLException e) {
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
	}
}

package com.hksoftworks.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static final Properties props = getJdbcProperties();
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(System.getenv("JDBC_URL"), 
					System.getenv("JDBC_USERNAME"), 
					System.getenv("JDBC_PASSWORD"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL State: " + e.getSQLState());
			throw new RuntimeException("Failed to get database connection");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			throw new RuntimeException("Failed to get driver class.");
		}
	}
	
	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			//Gets connection to src/main/resources
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load application.properties!");
		}
		return props;
	}
	
//	public static void main(String[] args) {
//		System.out.println(ConnectionManager.getConnection());
//	}
}

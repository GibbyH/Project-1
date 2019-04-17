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
			return DriverManager.getConnection(props.getProperty("jdbc.url"), 
					props.getProperty("jdbc.username"), 
					props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to load oracle.jdbc.OracleDriver");
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
